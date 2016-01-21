#include <stdio.h>
#include <assert.h>

class Multiplexer2{
	
	public:

		void initialize(){
			a=0;
			b=0;
			addr=0;
			s=0;
		}

		void inputs(int first, int second){
			a=first%2;
			b=second%2;
		}

		void selector(int selector){
			addr=selector%2;
		}

		void compute(){
			if (addr == 0){
				s=a;
			}
			else{
				s=b;
			}
		}

		int get_result(){
			return s;
		}

	private:

		int a, b, addr;
		int s;

};

int main(){

	Multiplexer2 my_multiplexer;

	my_multiplexer.initialize();

	my_multiplexer.inputs(0,1);
	my_multiplexer.selector(0);
	my_multiplexer.compute();
	assert (my_multiplexer.get_result() == 0);

	my_multiplexer.inputs(0,1);
	my_multiplexer.selector(1);
	my_multiplexer.compute();
	assert (my_multiplexer.get_result() == 1);

	fprintf(stdout, "Hardware test passed.\n");

	return 0;

}