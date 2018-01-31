package dsa.adt;


public class Vertex {
	private Object info;		//������Ϣ
	private LinkedList adjacentEdges;	//������ڽӱ߱�
	private LinkedList reAdjacentEdges;	//��������ڽӱ߱�����ͼʱΪ��
	private boolean visited;	//����״̬
	private Node vexPosition;	//�����ڶ�����е�λ��
	private int graphType;		//��������ͼ������
	private Object application;	//Ӧ����Ϣ�����������·��ʱΪPath����ؼ�·��ʱΪVtime
	//���췽��:��ͼG������һ���¶���
	public Vertex(Graph g, Object info) {
		this.info = info;
		adjacentEdges = new LinkedListDLNode();
		reAdjacentEdges = new LinkedListDLNode();
		visited = false;
		graphType = g.getType();
		vexPosition = g.insert(this);
		application = null;
	}
	//��������:�ж϶�������ͼ������
	private boolean isUnDiGraphNode(){ return graphType== Graph.UndirectedGraph;}
	
	//��ȡ�����ö�����Ϣ
	public Object getInfo(){ return info;}
	public void setInfo(Object obj){ this.info = info;}
	
	//�붥��Ķ���صķ���
	public int getDeg(){
		if (isUnDiGraphNode())
			return adjacentEdges.getSize();	//����ͼ�����(��/��)�ȼ�Ϊ�ڽӱ߱�Ĺ�ģ
		else
			return getOutDeg()+getInDeg();	//����ͼ����Ķ�Ϊ���������֮��
	}
	public int getOutDeg(){ 
		return adjacentEdges.getSize();		//��(��)��ͼ����ĳ���Ϊ�ڽӱ��ģ
	}
	public int getInDeg(){
		if (isUnDiGraphNode())
			return adjacentEdges.getSize();	//����ͼ�������Ⱦ������Ķ�
		else
			return reAdjacentEdges.getSize();//����ͼ�������Ϊ���ڽӱ�Ĺ�ģ
	}
	
	//��ȡ�붥������ı�
	public LinkedList getAdjacentEdges(){ return adjacentEdges;}
	public LinkedList getReAdjacentEdges(){
		if (isUnDiGraphNode())
			return adjacentEdges;	//����ͼ���������ڽӱ߱�,�����ڽӱ߱�����ڽӱ߱�
		else
			return reAdjacentEdges;
	}
	
	//ȡ����������ͼ���㼯�е�λ��
	public Node getVexPosition(){ return vexPosition;}

	//�붥�����״̬��ط���
	public boolean isVisited(){ return visited;}
	public void setToVisited(){ visited = true;}
	public void setToUnvisited(){ visited = false;}
	
	//ȡ�����ö���Ӧ����Ϣ
	protected Object getAppObj(){ return application;}
	protected void setAppObj(Object app){ application = app;}
	
	//���ö���״̬��Ϣ
	public void resetStatus(){
		visited = false;
		application = null;
	}
}
