package beakJoon.yoon;

public class Main {
	static int storey = 6665777;
	public static void main(String[] args)   {
		int tempStorey = storey;
		int cnt = 0;
		while(tempStorey>0){
			int ext = tempStorey%10;
			tempStorey/=10;
			int value = 0;

			if(ext==5){
				if(tempStorey%10 >=5) {
					tempStorey++;
					value = 10-ext;
				}
				else {
					value = ext;
				}
			}else if(ext > 5) {
				tempStorey++;
				value = 10 - ext;
			}
			else {
				value = ext;
			}

			cnt += value;

		}

		System.out.println(cnt);
	}

}