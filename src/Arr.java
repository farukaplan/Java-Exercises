class MyArray {
	private int[] arr;
    private int size;

	
	public MyArray() {
        size = 0;
		arr = new int[2];
	}
	
	public String addLast(int num) {
        if(size == arr.length) {
            int[] tempArr = new int[size * 2];
            System.arraycopy(arr, 0, tempArr, 0, size); 
            arr = tempArr;
        }

        arr[size] = num;
        size++;
	    return display();
	}
	
	public String addPosition(int pos, int num) {
        if(pos > size || pos < 0) {
            return "error\n";
        }

        if(size == arr.length) {
            int[] tempArr = new int[size * 2];
            System.arraycopy(arr, 0, tempArr, 0, size); 
            arr = tempArr;
        }

        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, size);
        newArr[pos] = num;
        System.arraycopy(arr, pos, newArr, pos + 1, size - pos);
        arr = newArr;
        size++;

        return display();
	}
	
	public String removeLast() {
		int[] newArr = new int[size];
        System.arraycopy(arr, 0, newArr, 0, size - 1);
        arr = newArr;
        size--;

        if(size == (arr.length / 4)) {
            int[] tempArr = new int[arr.length / 2];
            System.arraycopy(arr, 0, tempArr, 0, size); 
            arr = tempArr;
        }

        return display();
	}
	
	public String removePosition(int pos) {
		int[] newArr = new int[size - 1];
        System.arraycopy(arr, 0, newArr, 0, pos - 1);
        System.arraycopy(arr, pos + 1, newArr, pos, size - pos);
        arr = newArr;
        size--;

        if(size == (arr.length / 4)) {
            int[] tempArr = new int[arr.length / 2];
            System.arraycopy(arr, 0, tempArr, 0, size); 
            arr = tempArr;
        }

        return display();          
	}
	
	public String display() {
        StringBuilder sb = new StringBuilder();
		int i = 0;

        while(i < size) {
            sb.append(arr[i]).append(" ");
            i++;
        }

        sb.append("(").append(size).append("/").append(arr.length).append(")").append("\n");
        return sb.toString();
	}
}

///////////////////////////////////////////////////////////////////

public class Arr {
   public static void main(String[] args) {
      MyArray m = new MyArray();
      System.out.print(m.display());
      System.out.print(m.addLast(1));
      System.out.print(m.addLast(2));
      System.out.print(m.addLast(3));
      System.out.print(m.addPosition(2,4));
      System.out.print(m.removeLast());
   }
}