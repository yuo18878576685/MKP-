public class laosi {

	int n;
	int m;
	int[][] shuxing_all;					//��������
	int[] limite;							//��������
	int[] c_shuxing;						//��ǰ����
	double[] value_all;						//���м�ֵ
	double c_value=0;						//��ǰ��ֵ
	double bestv=0;							//���ŷ���ֵ
	int[] best_selection;					//����ֵ�ı������
	int[] selection;						//�������
	
	//���췽��
	public  laosi(int n,int m,int []limite,int [][]shuxing_all,double []value_all){
		this.n=n;
		this.m=m;
		this.limite=limite;
		this.shuxing_all=shuxing_all;
		this.value_all=value_all;
		this.best_selection = new int[n];
		this.selection=new int[50];
		this.c_shuxing = new int[50];	
	};
	//�����ͺ������޶���������ǰ����������������Ʒ�������Ƿ�ᳬ����������
	public boolean ok(int[] c_shuxing,int m,int[] limite,int t,int[][] shuxing_all){
		int i;
		for(i=0;i<m;i++){
			if(c_shuxing[i]+shuxing_all[i][t]<=limite[i])
				continue;
			else break;
		}
		if(i==m)
			return true;
		else 
			return false;
	}
	public void backtrack(int t) {
		//t����ָʾ����Ĳ������ڼ�������0��ʼ����ͬʱҲָʾ��ǰѡ���˼�����Ʒ
		if (t >= n) {  //�Ѿ�������Ҷ�ӽڵ���
			// �޽纯������ȥ��Щ���У��������������Ž����֦
			if (c_value > bestv) {
				bestv = c_value;
				// �������ŵ�selectionֵ���붯̬�Ż���������Ϊselection���ڲ�ͬ�ļ�֦�����з����仯
				for (int i = 0; i < n; i++) {
					best_selection[i] = selection[i]; // �����ŵ�ѡ�����б�����best_selection��
					// System.out.print(selection[i] + " ");
				}
			}
		}//��δ���������һ����Ʒ����Ҷ�ӽڵ㣬��ֱ������������;
		else {
			// ����������
			if (ok(c_shuxing,m,limite,t,shuxing_all)) {	//����Ʒt���뱳��,����������
				for(int i=0;i<m;i++){					//�����������ԣ�����ǰ����������
					c_shuxing[i] += shuxing_all[i][t];
				}
				c_value += value_all[t];				//���µ�ǰ�������ܼ�ֵ��������������Ʒ�ļ�ֵ

				selection[t] = 1;						//���뱳�������Ϊ1
				backtrack(t + 1);						//�������������һ��

				// ��������ǰ��ֵ��������ԭ
				for(int i=0;i<m;i++){					//��ԭ��ǰ�������ԣ�����ԭ��ǰ����������
					c_shuxing[i] -= shuxing_all[i][t];
				}
				c_value -= value_all[t];				//��ԭ��ǰ��ֵ
			}
			selection[t] = 0;							//�����뱳�������Ϊ0
			backtrack(t + 1); 							// ����������
		}
	}
}