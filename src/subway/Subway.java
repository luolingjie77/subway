package subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Subway {
	static int[][] way = new int[30][500];// �洢ÿ����·��վ��
	static int[][] dis = new int[500][500];// �洢����վ���ľ���
	static Map<String, Integer> maps = new HashMap<>();// �洢ÿ��վ���id��
	static int id = 1;
	static int[] wayTo = new int[500];// ·��
	static int[][] exchange = new int[500][500];// ���滻�˵�Ŀɻ��˵���·
	static int[] changeNumber = new int[500];// ����ÿ�����˵�Ŀɻ���·�ߵĸ���
//static WayTo wt=new WayTo();

	public static void shuchu(int[] dist, int[] path, int[][] exchange, int e, int s, int count, int[] changePoint,
			String baocun) {
		File file = new File("C:\\Users\\lenovo\\Desktop\\" + baocun);
		
		try {
			if (file.createNewFile() == false)
				;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter out = null;
		try {
			out = new FileWriter(file,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Subway sw = new Subway();
		int[] wayTo = new int[500];// ����·��
		String str = "����Ϊ" + dist[e] + "\n";
		char[] text = str.toCharArray();
		try {
			out.write(text);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = 0;
		wayTo[i] = e;
		i++;
		while (true) {
			e = path[e];
			wayTo[i] = e;
			if (e == s)
				break;
			i++;
		}
		int j;
		int p, pp;
		for (j = i; j >= 0; j--) {
			for (int q = 0; q < count; q++) {
				if (wayTo[j] == changePoint[q])// ����ĵ���һ�����˵㣬��Ҫ������˵�������
				{
					int m = 0, n = 0;
					p = changePoint[q];
					pp = wayTo[j + 1];
					int flag = 0;
					for (m = 0; m <= 2; m++) {
						for (n = 0; n <= 2; n++) {
							if (exchange[p][m] == exchange[pp][n] && exchange[p][m] != 0 && exchange[pp][n] != 0) {
								flag = exchange[pp][n];

							}
						}
					}
					if (flag == 1) {
						str = "һ����\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 2) {
						str = "������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 3) {
						str = "�ĺ���\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 4) {
						str = "�����\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 5) {
						str = "������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 6) {
						str = "�ߺ���\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 7) {
						str = "�˺��߱���\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 8) {
						str = "�ź���\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 9) {
						str = "ʮ����\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 10) {
						str = "ʮ������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 11) {
						str = "ʮ�ĺ��߶���\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 12) {
						str = "ʮ�ĺ�������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 13) {
						str = "ʮ�����\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 14) {
						str = "ʮ������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 15) {
						str = "��ͨ��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 16) {
						str = "��ƽ��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 17) {
						str = "��ׯ��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 18) {
						str = "��ɽ��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 19) {
						str = "������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 20) {
						str = "������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 21) {
						str = "S1��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 22) {
						str = "������\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 23) {
						str = "�෿��\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 24) {
						str = "�˺����϶�\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
			}
			str = sw.getKey(wayTo[j]) + "\n";
			text = str.toCharArray();
			try {
				out.write(text);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void searchWay(String name, String args) // ����ָ��������
	{
		int wayNumber = 0;
		if (name.compareTo("һ����") == 0) {
			wayNumber = 1;
		} else if (name.compareTo("������") == 0) {
			wayNumber = 2;
		} else if (name.compareTo("�ĺ���") == 0) {
			wayNumber = 3;
		} else if (name.compareTo("�����") == 0) {
			wayNumber = 4;
		} else if (name.compareTo("������") == 0) {
			wayNumber = 5;
		} else if (name.compareTo("�ߺ���") == 0) {
			wayNumber = 6;
		} else if (name.compareTo("�˺��߱���") == 0) {
			wayNumber = 7;
		} else if (name.compareTo("�ź���") == 0) {
			wayNumber = 8;
		} else if (name.compareTo("ʮ����") == 0) {
			wayNumber = 9;
		} else if (name.compareTo("ʮ������") == 0) {
			wayNumber = 10;
		} else if (name.compareTo("ʮ�ĺ��߶���") == 0) {
			wayNumber = 11;
		} else if (name.compareTo("ʮ�ĺ�������") == 0) {
			wayNumber = 12;
		} else if (name.compareTo("ʮ�����") == 0) {
			wayNumber = 13;
		} else if (name.compareTo("ʮ������") == 0) {
			wayNumber = 14;
		} else if (name.compareTo("��ͨ��") == 0) {
			wayNumber = 15;
		} else if (name.compareTo("��ƽ��") == 0) {
			wayNumber = 16;
		} else if (name.compareTo("��ׯ��") == 0) {
			wayNumber = 17;
		} else if (name.compareTo("��ɽ��") == 0) {
			wayNumber = 18;
		} else if (name.compareTo("������") == 0) {
			wayNumber = 19;
		} else if (name.compareTo("������") == 0) {
			wayNumber = 20;
		} else if (name.compareTo("S1��") == 0) {
			wayNumber = 21;
		} else if (name.compareTo("������") == 0) {
			wayNumber = 22;
		} else if (name.compareTo("�෿��") == 0) {
			wayNumber = 23;
		} else if (name.compareTo("�˺����϶�") == 0) {
			wayNumber = 24;
		} else {
			System.out.println("����·������");
			return;
		}
		File file = new File("C:\\Users\\lenovo\\Desktop\\" + args);
		try {
			if (file.createNewFile() == false)
				return;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter out = null;
		try {
			out = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String output = name + "������·��Ϊ��\n";
		char[] text = output.toCharArray();
		try {
			out.write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 1;
		while (way[wayNumber][i] != 0)// ��������·�ϵ�վ��һ���������station.txt�ļ���
		{
			String key = getKey(way[wayNumber][i]) + " ";
			text = key.toCharArray();
			try {
				out.write(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int findMinDist(int[] dist, int[] collected)// Ѱ��δ����¼������dist��С��
	{
		int minv = 0, v;
		int minDist = 100000;

		for (v = 1; v < id; v++) {
			if (collected[v] == 0 && dist[v] < minDist) {
				minDist = dist[v];
				minv = v;
				// System.out.println(v);
			}
		}
		if (minDist < 100000) {
			return minv;
		}
		return -1;
	}

	public static void dijkstra(String station1, String station2, String baocun)// ����dijkstra����������֮�����̾���
	{
		int[] collected = new int[500];// վ���Ƿ��Ѿ�����¼��������㵽���������·���Ƿ��Ѿ������
		int[] dist = new int[500];// ��¼����
		int[] path = new int[500];// ��¼��;��·��
		int[] changePoint = new int[100];// ��¼���˵�
		int[] changeCount = new int[500];// ��¼���˴���
		int count = 0;
		int s = maps.get(station1);// ����id��
		int e = maps.get(station2);// �յ��id��
		int v, w;

		for (v = 0; v < 500; v++) {
			changeCount[v] = 0;
		}
		for (v = 1; v < id; v++) {
			dist[v] = dis[s][v];
			if (dist[v] < 100000) {
				path[v] = s;
			} else
				path[v] = -1;
			collected[v] = 0;
		}

		dist[s] = 0;
		collected[s] = 1;
		int p, pp;
		int count1 = 0;
		while (true) {
			v = findMinDist(dist, collected);// �ҵ�������С�ĵ�
			if (v == e)
				break;
			if (v == -1) {
				break;
			}

			collected[v] = 1;
			int m = 0, n = 0;
			int flag = 0;
			if (path[v] != s) {
				p = path[v];// ��ǰվ���ǰһ��վ��
				pp = path[p];// ��ǰվ���ǰǰվ��
				flag = 0;
				for (m = 0; m <= 2; m++)// �жϵ�ǰվ���ǰһ��վ�����ڵ���·�����
				{
					for (n = 0; n <= 2; n++) {
						if (exchange[v][m] == exchange[p][n] && exchange[v][m] != 0 && exchange[p][n] != 0) {
							flag = exchange[p][n];

						}
					}
				}
				for (m = 0; m <= 2; m++)// �ж���ǰһ��վ���Ƿ���������·��
				{
					if (flag == exchange[pp][m])
						break;
				}
				if (m > 2)// �����ڣ�ǰһ��վ����һ�����˵㣬���滻����Ϣ
				{
					changePoint[count] = v;
					changeCount[v] = changeCount[p] + 1;
					count++;

				} else {
					changeCount[v] = changeCount[p];
				}
			}
			for (w = 1; w < id; w++) {
				if (collected[w] == 0 && dis[v][w] < 100000) {
					if (dist[v] + dis[v][w] < dist[w]) {
						dist[w] = dist[v] + dis[v][w];
						path[w] = v;
						if (w == e) {
							p = path[w];
							pp = path[p];
							for (m = 0; m <= 2; m++) {
								for (n = 0; n <= 2; n++) {
									if (exchange[w][m] == exchange[p][n] && exchange[w][m] != 0
											&& exchange[p][n] != 0) {
										flag = exchange[p][n];

									}
								}
							}
							for (m = 0; m <= 2; m++) {
								if (flag == exchange[pp][m])
									break;
							}
							if (m > 2) {
								changePoint[count] = w;
								count1 = count;
								changeCount[w] = changeCount[p] + 1;
								count++;
							} else {
								changeCount[w] = changeCount[p];
							}
						}
					} else if (dist[v] + dis[v][w] == dist[w]) {
						if (w == e) {
							p = v;
							pp = path[v];
							for (m = 0; m <= 2; m++) {
								for (n = 0; n <= 2; n++) {
									if (exchange[w][m] == exchange[p][n] && exchange[w][m] != 0
											&& exchange[p][n] != 0) {
										flag = exchange[p][n];

									}
								}
							}
							for (m = 0; m <= 2; m++) {
								if (flag == exchange[pp][m])
									break;
							}
							if (changeCount[p] < changeCount[w] && m <= 2) {
								changeCount[w] = changeCount[p];
								path[w] = v;
								changePoint[count1] = 0;
							} else if (changeCount[p] + 1 == changeCount[w] && m > 2) {
								changePoint[count] = w;
								count++;
								shuchu(dist, path, exchange, e, s, count, changePoint, baocun);
								changeCount[w] = changeCount[p] + 1;
								path[w] = v;

							} else if (changeCount[p] == changeCount[w] && m <= 2) {
								shuchu(dist, path, exchange, e, s, count, changePoint, baocun);// ������WayTo�еĺ���
								path[w] = v;
								changePoint[count1]=0;
							}
						}
					}
				}
			}
		}
		shuchu(dist, path, exchange, e, s, count, changePoint, baocun);
	}

	public static String getKey(int value)// ����id�ŵõ�վ�������
	{
		String key = null;
		for (String getKey : maps.keySet()) {
			if (maps.get(getKey).equals(value)) {
				key = getKey;
			}
		}
		return key;
	}

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 0; i < 500; i++) {
			changeNumber[i] = 0;
		}
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 500; j++) {
				dis[i][j] = 100000;
			}
		}
		String name = null;// �ļ�����
		String jihaoxian = null;// ����ļ�����
		String baocun = null;// Ҫ�����ȥ���ļ�������
		String name1 = null, name2 = null;// �����յ�
		if (args[0].compareTo("-map") == 0)// �ж�������Ҫִ��ʲô����������
		{
			name = args[1];
		} else if (args[0].compareTo("-a") == 0) {
			name = args[3];
			jihaoxian = args[1];
			baocun = args[5];
		} else if (args[0].compareTo("-b") == 0) {
			name = args[4];
			name1 = args[1];
			name2 = args[2];
			baocun = args[6];
		}
		File file = new File("C:\\Users\\lenovo\\Desktop\\" + name);
		if (!file.exists()) {
			System.out.println("�ڵ������Ϣ�ļ�δ�ҵ�");
			System.exit(0);
		}
		Scanner s = new Scanner(file);
		String station;// ����վ��
		String preStation = null;// ��ǰվ���ǰһ��վ��
		int wayNumber = 0;
		int i = 1;
		int flag = 1;
		int count = 0;
		int jst = 0;// ��ˮ̶
		int xzm = 0;// ��ֱ��
		while (s.hasNext()) {
			station = s.next();
			if (station.compareTo("һ����") == 0) {
				wayNumber = 1;// �����ߵ�id�ţ��������Ĳ���
				i = 1;
				flag = 1;
			} else if (station.compareTo("������") == 0) {
				wayNumber = 2;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�ĺ���") == 0) {
				wayNumber = 3;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�����") == 0) {
				wayNumber = 4;
				i = 1;
				flag = 1;
			} else if (station.compareTo("������") == 0) {
				wayNumber = 5;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�ߺ���") == 0) {
				wayNumber = 6;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�˺��߱���") == 0) {
				wayNumber = 7;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�ź���") == 0) {
				wayNumber = 8;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ����") == 0) {
				wayNumber = 9;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ������") == 0) {
				wayNumber = 10;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ�ĺ��߶���") == 0) {
				wayNumber = 11;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ�ĺ�������") == 0) {
				wayNumber = 12;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ�����") == 0) {
				wayNumber = 13;
				i = 1;
				flag = 1;
			} else if (station.compareTo("ʮ������") == 0) {
				wayNumber = 14;
				i = 1;
				flag = 1;
			} else if (station.compareTo("��ͨ��") == 0) {
				wayNumber = 15;
				i = 1;
				flag = 1;
			} else if (station.compareTo("��ƽ��") == 0) {
				wayNumber = 16;
				i = 1;
				flag = 1;
			} else if (station.compareTo("��ׯ��") == 0) {
				wayNumber = 17;
				i = 1;
				flag = 1;
			} else if (station.compareTo("��ɽ��") == 0) {
				wayNumber = 18;
				i = 1;
				flag = 1;
			} else if (station.compareTo("������") == 0) {
				wayNumber = 19;
				i = 1;
				flag = 1;
			} else if (station.compareTo("������") == 0) {
				wayNumber = 20;
				i = 1;
				flag = 1;
			} else if (station.compareTo("S1��") == 0) {
				wayNumber = 21;
				i = 1;
				flag = 1;
			} else if (station.compareTo("������") == 0) {
				wayNumber = 22;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�෿��") == 0) {
				wayNumber = 23;
				i = 1;
				flag = 1;
			} else if (station.compareTo("�˺����϶�") == 0) {
				wayNumber = 24;
				i = 1;
				flag = 1;
			} else {
				if (maps.containsKey(station) == false)// ��վ�㸳idֵ
				{
					maps.put(station, id);
					id++;
				}
				if (station.compareTo("��ˮ̶") == 0) {
					jst = maps.get(station);
				}
				if (station.compareTo("��ֱ��") == 0) {
					xzm = maps.get(station);
				}
				int j = changeNumber[maps.get(station)];// ��stationվ��Ŀɻ�����·�ĸ���
				exchange[maps.get(station)][j] = wayNumber;// ����ɻ��˵���·��id��
				changeNumber[maps.get(station)]++;
				way[wayNumber][i] = maps.get(station);// ���������·�ĸ���վ��
				i++;
				if (flag == 1) {
					flag = 0;
				} else {
					dis[maps.get(preStation)][maps.get(station)] = 1;// ��������վ��֮��ľ���Ϊ1
					dis[maps.get(station)][maps.get(preStation)] = 1;
				}
				preStation = station;
			}
		}
		dis[jst][xzm] = 1;// ��Ϊ��ˮ̶����ֱ��Ϊѭ����������������֮��ľ���ҲΪ1
		if (args[0].compareTo("-a") == 0)
			searchWay(args[1], args[5]);
		else if (args[0].compareTo("-b") == 0) {
			if (maps.containsKey(name1) == false || maps.containsKey(name2) == false) {
				System.out.println("��վ�㲻����");
				System.exit(0);
			}
			dijkstra(name1, name2, baocun);
		}
	}
}
