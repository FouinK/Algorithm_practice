
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int N;
	static TreeMap<Integer, Integer> map = new TreeMap<>();
 	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N+1];
		visit = new boolean[N + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		dfs(1);

		for (Integer key : map.keySet()) {
			if (key != 1) {
				sb.append(map.get(key)).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void dfs(int start) {

		for (int i = 0; i < arr[start].size(); i++) {
			int next = arr[start].get(i);
			if (!visit[next]) {
				map.put(next, start);
				visit[next] = true;
				dfs(next);
			}
		}

	}


}