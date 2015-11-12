class Multiplexer2{
	int a, b, addr;
	int s;

	public Multiplexer2(){
		a=0;
		b=0;
		addr=0;
		s=0;
	}

	public void inputs(int first, int second){
		a=first%2;
		b=second%2;
	}

	public void selector(int selector){
		addr=selector%2;
	}

	public void compute(){
		if (addr == 0){
			s=a;
		}
		else{
			s=b;
		}
	}

	public int get_result(){
		return s;
	}

}


class main{

	public static void main (String [] args){

		Multiplexer2 my_multiplexer = new Multiplexer2();

		my_multiplexer.inputs(0,1);
		my_multiplexer.selector(0);
		my_multiplexer.compute();
		assert (my_multiplexer.get_result() == 0);

		my_multiplexer.inputs(0,1);
		my_multiplexer.selector(1);
		my_multiplexer.compute();
		assert (my_multiplexer.get_result() == 1);

		System.out.println("Hardware test passed.");

	}
}