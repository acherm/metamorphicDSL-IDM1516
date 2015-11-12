all:
	ghdl -a multiplexer2.vhdl
	ghdl -a test_bench.vhdl
	ghdl -e test_bench
	
run:
	ghdl -r test_bench

clean:
	rm -f *.o *.cf test_bench