import java.util.Scanner;
public class Bag{
	public static void main(String args[]) {
		
		//����
		Scanner ls = new Scanner(System.in);//����Scanner�Ķ���ls
		
		int n = ls.nextInt();// ��ʾ����ĸ���
	    int m = ls.nextInt();//��ƷԼ������
	    double maxValue = ls.nextDouble();
	    
	    double[] value_all = new double[n];
	    for(int i = 0; i < n; i++) {        //��Ʒ��ֵ
	    	value_all[i] = ls.nextDouble();
	    }
	    
	    int[][] shuxing_all =  new int[m][n];
	    for(int i = 0; i < m; i++) {            //��Ʒ����
	    	for(int j=0;j < n;j++) {
	    		shuxing_all[i][j] = ls.nextInt();
	    	}
	    }
	    int[] limite = new int[m];				//Լ������
	    for(int j = 0; j < m; j++) {            //��ƷԼ������
	    	limite[j] = ls.nextInt();
        }
	    
	    laosi b = new laosi(n,m,limite,shuxing_all,value_all); 
		b.backtrack(0);
		System.out.println("���ݷ�����������ֵΪ��" + b.bestv);
	}
}