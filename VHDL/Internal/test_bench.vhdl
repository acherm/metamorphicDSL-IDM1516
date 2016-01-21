entity test_bench is
end test_bench;

architecture behav of test_bench is
  component multiplexer2
    port (a : in bit; b : in bit; adr : in bit; s : out bit);
  end component;
  for multiplexer2_0: multiplexer2 use entity work.TwoInputOneOutput;
  signal a, b, adr, s : bit;
begin
  multiplexer2_0: multiplexer2 port map (a => a, b => b, adr => adr,
                           s => s);
  process
     type pattern_type is record
        a, b, adr : bit;
        s : bit;
     end record;
     type pattern_array is array (natural range <>) of pattern_type;
     constant patterns : pattern_array :=
       (('0', '1', '0', '0'),
        ('0', '1', '1', '1'));
  begin
     for i in patterns'range loop
        a <= patterns(i).a;
        b <= patterns(i).b;
        adr <= patterns(i).adr;
        wait for 1 ns;
        assert s = patterns(i).s
           report "bad sum value" severity error;
     end loop;
     assert false report "Hardware test passed." severity note;
     wait;
  end process;
end behav;