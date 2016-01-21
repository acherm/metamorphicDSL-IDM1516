library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

ENTITY TwoInputOneOutput IS 

   PORT
   (
     a   : IN BIT;
     b   : IN BIT;
     adr : IN BIT;
     s   : OUT BIT
   );

END TwoInputOneOutput;


ARCHITECTURE multiplexer2 OF TwoInputOneOutput IS

BEGIN
    s <=  (a  AND NOT adr)
      OR  (b  AND adr);
END multiplexer2;