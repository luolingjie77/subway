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
	static int[][] way = new int[30][500];// 存储每条线路的站点
	static int[][] dis = new int[500][500];// 存储两个站点间的距离
	static Map<String, Integer> maps = new HashMap<>();// 存储每个站点的id号
	static int id = 1;
	static int[] wayTo = new int[500];// 路径
	static int[][] exchange = new int[500][500];// 保存换乘点的可换乘的线路
	static int[] changeNumber = new int[500];// 保存每个换乘点的可换乘路线的个数
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
		int[] wayTo = new int[500];// 保存路径
		String str = "距离为" + dist[e] + "\n";
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
				if (wayTo[j] == changePoint[q])// 如果改点是一个换乘点，就要输出换乘到几号线
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
						str = "一号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 2) {
						str = "二号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 3) {
						str = "四号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 4) {
						str = "五号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 5) {
						str = "六号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 6) {
						str = "七号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 7) {
						str = "八号线北段\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 8) {
						str = "九号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 9) {
						str = "十号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 10) {
						str = "十三号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 11) {
						str = "十四号线东段\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 12) {
						str = "十四号线西段\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 13) {
						str = "十五号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 14) {
						str = "十六号线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 15) {
						str = "八通线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 16) {
						str = "昌平线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 17) {
						str = "亦庄线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 18) {
						str = "房山线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 19) {
						str = "机场线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 20) {
						str = "大兴线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 21) {
						str = "S1线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 22) {
						str = "西郊线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 23) {
						str = "燕房线\n";
						text = str.toCharArray();
						try {
							out.write(text);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (flag == 24) {
						str = "八号线南段\n";
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

	public static void searchWay(String name, String args) // 搜索指定地铁线
	{
		int wayNumber = 0;
		if (name.compareTo("一号线") == 0) {
			wayNumber = 1;
		} else if (name.compareTo("二号线") == 0) {
			wayNumber = 2;
		} else if (name.compareTo("四号线") == 0) {
			wayNumber = 3;
		} else if (name.compareTo("五号线") == 0) {
			wayNumber = 4;
		} else if (name.compareTo("六号线") == 0) {
			wayNumber = 5;
		} else if (name.compareTo("七号线") == 0) {
			wayNumber = 6;
		} else if (name.compareTo("八号线北段") == 0) {
			wayNumber = 7;
		} else if (name.compareTo("九号线") == 0) {
			wayNumber = 8;
		} else if (name.compareTo("十号线") == 0) {
			wayNumber = 9;
		} else if (name.compareTo("十三号线") == 0) {
			wayNumber = 10;
		} else if (name.compareTo("十四号线东段") == 0) {
			wayNumber = 11;
		} else if (name.compareTo("十四号线西段") == 0) {
			wayNumber = 12;
		} else if (name.compareTo("十五号线") == 0) {
			wayNumber = 13;
		} else if (name.compareTo("十六号线") == 0) {
			wayNumber = 14;
		} else if (name.compareTo("八通线") == 0) {
			wayNumber = 15;
		} else if (name.compareTo("昌平县") == 0) {
			wayNumber = 16;
		} else if (name.compareTo("亦庄线") == 0) {
			wayNumber = 17;
		} else if (name.compareTo("房山线") == 0) {
			wayNumber = 18;
		} else if (name.compareTo("机场线") == 0) {
			wayNumber = 19;
		} else if (name.compareTo("大兴线") == 0) {
			wayNumber = 20;
		} else if (name.compareTo("S1线") == 0) {
			wayNumber = 21;
		} else if (name.compareTo("西郊线") == 0) {
			wayNumber = 22;
		} else if (name.compareTo("燕房线") == 0) {
			wayNumber = 23;
		} else if (name.compareTo("八号线南段") == 0) {
			wayNumber = 24;
		} else {
			System.out.println("该线路不存在");
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
		String output = name + "经过的路线为：\n";
		char[] text = output.toCharArray();
		try {
			out.write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 1;
		while (way[wayNumber][i] != 0)// 把这条线路上的站点一个个保存进station.txt文件中
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

	public static int findMinDist(int[] dist, int[] collected)// 寻找未被收录顶点中dist最小者
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

	public static void dijkstra(String station1, String station2, String baocun)// 利用dijkstra来计算两点之间的最短距离
	{
		int[] collected = new int[500];// 站点是否已经被收录，即从起点到这个点的最短路径是否已经保存好
		int[] dist = new int[500];// 记录距离
		int[] path = new int[500];// 记录沿途的路径
		int[] changePoint = new int[100];// 记录换乘点
		int[] changeCount = new int[500];// 记录换乘次数
		int count = 0;
		int s = maps.get(station1);// 起点的id号
		int e = maps.get(station2);// 终点的id号
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
			v = findMinDist(dist, collected);// 找到距离最小的点
			if (v == e)
				break;
			if (v == -1) {
				break;
			}

			collected[v] = 1;
			int m = 0, n = 0;
			int flag = 0;
			if (path[v] != s) {
				p = path[v];// 当前站点的前一个站点
				pp = path[p];// 当前站点的前前站点
				flag = 0;
				for (m = 0; m <= 2; m++)// 判断当前站点和前一个站点所在的线路的序号
				{
					for (n = 0; n <= 2; n++) {
						if (exchange[v][m] == exchange[p][n] && exchange[v][m] != 0 && exchange[p][n] != 0) {
							flag = exchange[p][n];

						}
					}
				}
				for (m = 0; m <= 2; m++)// 判断再前一个站点是否在这条线路上
				{
					if (flag == exchange[pp][m])
						break;
				}
				if (m > 2)// 若不在，前一个站点是一个换乘点，保存换乘信息
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
								shuchu(dist, path, exchange, e, s, count, changePoint, baocun);// 调用类WayTo中的函数
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

	public static String getKey(int value)// 根据id号得到站点的名称
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
		String name = null;// 文件名称
		String jihaoxian = null;// 输入的几号线
		String baocun = null;// 要保存进去的文件的名称
		String name1 = null, name2 = null;// 起点和终点
		if (args[0].compareTo("-map") == 0)// 判断命令是要执行什么，参数处理
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
			System.out.println("节点基本信息文件未找到");
			System.exit(0);
		}
		Scanner s = new Scanner(file);
		String station;// 读入站点
		String preStation = null;// 当前站点的前一个站点
		int wayNumber = 0;
		int i = 1;
		int flag = 1;
		int count = 0;
		int jst = 0;// 积水潭
		int xzm = 0;// 西直门
		while (s.hasNext()) {
			station = s.next();
			if (station.compareTo("一号线") == 0) {
				wayNumber = 1;// 几号线的id号，方便后面的查找
				i = 1;
				flag = 1;
			} else if (station.compareTo("二号线") == 0) {
				wayNumber = 2;
				i = 1;
				flag = 1;
			} else if (station.compareTo("四号线") == 0) {
				wayNumber = 3;
				i = 1;
				flag = 1;
			} else if (station.compareTo("五号线") == 0) {
				wayNumber = 4;
				i = 1;
				flag = 1;
			} else if (station.compareTo("六号线") == 0) {
				wayNumber = 5;
				i = 1;
				flag = 1;
			} else if (station.compareTo("七号线") == 0) {
				wayNumber = 6;
				i = 1;
				flag = 1;
			} else if (station.compareTo("八号线北段") == 0) {
				wayNumber = 7;
				i = 1;
				flag = 1;
			} else if (station.compareTo("九号线") == 0) {
				wayNumber = 8;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十号线") == 0) {
				wayNumber = 9;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十三号线") == 0) {
				wayNumber = 10;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十四号线东段") == 0) {
				wayNumber = 11;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十四号线西段") == 0) {
				wayNumber = 12;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十五号线") == 0) {
				wayNumber = 13;
				i = 1;
				flag = 1;
			} else if (station.compareTo("十六号线") == 0) {
				wayNumber = 14;
				i = 1;
				flag = 1;
			} else if (station.compareTo("八通线") == 0) {
				wayNumber = 15;
				i = 1;
				flag = 1;
			} else if (station.compareTo("昌平县") == 0) {
				wayNumber = 16;
				i = 1;
				flag = 1;
			} else if (station.compareTo("亦庄线") == 0) {
				wayNumber = 17;
				i = 1;
				flag = 1;
			} else if (station.compareTo("房山线") == 0) {
				wayNumber = 18;
				i = 1;
				flag = 1;
			} else if (station.compareTo("机场线") == 0) {
				wayNumber = 19;
				i = 1;
				flag = 1;
			} else if (station.compareTo("大兴线") == 0) {
				wayNumber = 20;
				i = 1;
				flag = 1;
			} else if (station.compareTo("S1线") == 0) {
				wayNumber = 21;
				i = 1;
				flag = 1;
			} else if (station.compareTo("西郊线") == 0) {
				wayNumber = 22;
				i = 1;
				flag = 1;
			} else if (station.compareTo("燕房线") == 0) {
				wayNumber = 23;
				i = 1;
				flag = 1;
			} else if (station.compareTo("八号线南段") == 0) {
				wayNumber = 24;
				i = 1;
				flag = 1;
			} else {
				if (maps.containsKey(station) == false)// 给站点赋id值
				{
					maps.put(station, id);
					id++;
				}
				if (station.compareTo("积水潭") == 0) {
					jst = maps.get(station);
				}
				if (station.compareTo("西直门") == 0) {
					xzm = maps.get(station);
				}
				int j = changeNumber[maps.get(station)];// 该station站点的可换乘线路的个数
				exchange[maps.get(station)][j] = wayNumber;// 保存可换乘的线路的id号
				changeNumber[maps.get(station)]++;
				way[wayNumber][i] = maps.get(station);// 保存各个线路的各个站点
				i++;
				if (flag == 1) {
					flag = 0;
				} else {
					dis[maps.get(preStation)][maps.get(station)] = 1;// 设置相邻站点之间的距离为1
					dis[maps.get(station)][maps.get(preStation)] = 1;
				}
				preStation = station;
			}
		}
		dis[jst][xzm] = 1;// 因为积水潭和西直门为循环，所以他们两个之间的距离也为1
		if (args[0].compareTo("-a") == 0)
			searchWay(args[1], args[5]);
		else if (args[0].compareTo("-b") == 0) {
			if (maps.containsKey(name1) == false || maps.containsKey(name2) == false) {
				System.out.println("该站点不存在");
				System.exit(0);
			}
			dijkstra(name1, name2, baocun);
		}
	}
}
