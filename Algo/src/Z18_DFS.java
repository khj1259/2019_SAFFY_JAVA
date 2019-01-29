/**
 * 그래프에서 모든 정점을 빠짐없이 순회하는 방법
 * DFS
 * BFS
 */
public class Z18_DFS {
	public static void main(String[] args) {
		int[][] G = {	// 그래프에서 연결된 정점들의 간선정보를 저장
				{},		// 정점 0에 인접한 정점, 안씀 버림
				{2,3},	// 정점 1에 인접한 정점
				{1,4,5},// 정점 2에 인접한 정점
				{1,7},	// 정점 3에 인접한 정점
				{2,6},	// 정점 4에 인접한 정점
				{2,6},	// 정점 5에 인접한 정점
				{4,5,7},// 정점 6에 인접한 정점
				{3,6},	// 정점 7에 인접한 정점
		};
		
		int[] stack = new int[10];
		int top = -1;
		boolean[] visited = new boolean[8]; // 0은 안씀
		
		//시작 정점 하나를 결정 후 방문, 스택에 넣고, 반복을 시작
		int v = 1; // 시작 정점 A를 릐미
		System.out.println(v+" ");// 방문해서 할 일
		visited[v] = true; // 방문여부 체크
		stack[++top] = v; // 마지막 갈림길을 확인하기 위해 지나가는 정점들을 저장
		
		// 반복, 스택에서 값을 꺼내서 인접한 정점중 방문 안한 정점을 찾아서 방문
		while(top > -1) { // 반복 종료 : 스택에 비워지면 종료
			v = stack[top]; // 마지막 정점을 읽어옴 (삭제는 안함)
			int w = -1; // 다음 갈 정점, 플래그 변수 역할
			for (int i = 0; i < G[v].length; i++) { // 인접한 정점 만큼 반복
				if(!visited[G[v][i]]) { // 방문하지 않았으면
					w = G[v][i]; // 다음 갈 정점
					System.out.println(w+" ");
					visited[w] = true;
					stack[++top] = w; // 스택에 마지막 갈림길 저장
					break; // 확인이 되면 반복을 빠져나감
				}
			}
			if(w == -1) { // 인접한 정점 중 방문 안한 정점이 없음
				top--;
			}
			
		}
		
		
	}//end of main
}//end of class
