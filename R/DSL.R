# Chargement des librairies pour Java
library(rJava)
library(DBI)
library(RMySQL)

con<-dbConnect(RMySQL::MySQL(),user="user_14008374", password="blabla",dbname="base_14008374", host="anteros.istic.univ-rennes1.fr")
clients<-dbGetQuery(con,"SELECT code_client from Profil")
produits<-dbGetQuery(con,"SELECT code_produit from Produit")
for(i in 1:length(clients$code_client))
	{
		for(j in 1:length(produits$code_produit))
		{         
			cl<-clients$code_client[i]
			pr<-produits$code_produit[j]
			req<- paste0("SELECT quantite from QuantiteReelle where reel_produit_code_produit like '",pr,"' and reel_profil_code_client like '",cl,"'")

			#Recuperation des quantites
			quantiter<-dbGetQuery(con,req)

			#Fonction de prevision
			nouvelle<-ts(quantiter$quantite,frequency=3)
			liss_triple<-HoltWinters(nouvelle) 
			pred=predict(liss_triple,n.ahead=3)
			
			#Fonction d'insertion
			reqId<-paste0("SELECT profil_tournee_id from Profil_Tournee where profil_tournee_code_client like '",cl,"'")
			getId<-dbGetQuery(con, reqId)
			id<-getId$profil_tournee_id[1]
			
			#Recuperation jours tournee
			reqdays<-paste0("SELECT lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche from Tournee where id like '",id,"'")  
			days<-dbGetQuery(con, reqdays)
			l<-list()
			
			for(a in 1:7)
			{
				if(days[a]==1)
				{
					l<-c(l,list(colnames(days[a])))
				}
			}

			lastdate1<-dbGetQuery(con, paste0("SELECT date FROM QuantiteReelle where reel_profil_code_client like '",cl,"' ORDER BY date DESC LIMIT 1"))
			lastdate2<-lastdate1$date[1]
			lastdate<-weekdays(as.Date(lastdate2))
		
			#Creation vecteur jours pr�visions

			if(lastdate==l[1])
			{
				joursprevus1<-as.Date(lastdate2)+2	
				joursprevus2<-as.Date(lastdate2)+4
				joursprevus3<-as.Date(lastdate2)+7
			}
			if(lastdate==l[2])
			{
				joursprevus1<-as.Date(lastdate2)+2	
				joursprevus2<-as.Date(lastdate2)+5
				joursprevus3<-as.Date(lastdate2)+7
			}
			if(lastdate==l[3])
			{
				joursprevus1<-as.Date(lastdate2)+3	
				joursprevus2<-as.Date(lastdate2)+5
				joursprevus3<-as.Date(lastdate2)+7
			}	
			
			#Creation data frame -> matrice colonne jours pr�v colonne qtes prev
			d<-list()
			d<-c(joursprevus1,joursprevus2,joursprevus3)
			z = data.frame(d,pred)

			#R�cup�ration dernier jour table pr�vision
			getjourprevision<-dbGetQuery(con, paste0("SELECT date FROM Prevision where prevision_profil_code_client like '",cl,"' and prevision_produit_code_produit like '",pr,"' ORDER BY date DESC LIMIT 1"))
			lastjourprevu<-getjourprevision$date[1]

			#Comparaison avec jours pr�vus + modifier data frame
			Nlastjourprevu<-format(as.Date(lastjourprevu), "%d")
			if(is.na(lastjourprevu) == FALSE)
			{
				for (y in 1:3)
				{
					Nnewjourprevu<-format(as.Date(z$d[y]), "%d")
					ecartjoursprevus<-difftime(lastjourprevu, z$d[y], unit = "days")
					if( ecartjoursprevus >0|| Nlastjourprevu==Nnewjourprevu )
					{
						z$fit[y]<- -1
					}
				}	
			}

			#Data frame = just bons jours pr�vus + qt�s -> insertion table pr�vus
			for(k in 1:length(z$fit))
			{
				if(z$fit[k] != -1)
				{
					p<-z$fit[k]
					dd<-z$d[k]
					query <- paste0("INSERT INTO Prevision(quantite, date, prevision_produit_code_produit, prevision_profil_code_client) VALUES(",p, ",", "'", dd, "'", ",", "'",pr, "'", ",", "'", cl, "'", ")")
					dbGetQuery(con, query)
				}
			}
		}
}

#Fermeture des connections BD ouvertes
all_cons <- dbListConnections(MySQL())
for(con in all_cons)
{
	dbDisconnect(con)
}