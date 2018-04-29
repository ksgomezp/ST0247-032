import java.util.*;
public class Punto1_2
{
public static int heldKarp(Digraph g) {
       List<List<Integer>> subConj = generarSubCon(g.size()-1);
       List<List<Integer>[]> tabla1 = new LinkedList();
       for(List<Integer> sub : subConj){
           for(int i = 1; i < g.size(); i++){
               if(!sub.contains(i)){
                   List<Integer>[] temp = new LinkedList[3];
                   List<Integer> temp2 = new LinkedList(); temp2.add(i);
                   temp[0] = temp2;
                   temp[1] = sub;
                   tabla1.add(temp);
               }
           }
       }
       List listFinal[] = new LinkedList[3];
       List listTemp = new LinkedList(); listTemp.add(0);
       listFinal[0] = listTemp;
       listFinal[1] = subConj.get(subConj.size()-1);
       tabla1.add(listFinal);
       
       int min = Integer.MAX_VALUE;
       for(List<Integer>[] s : tabla1){
           if(s[1].size() == 0){
               List<Integer> temp2 = new LinkedList();
               temp2.add(g.getWeight(0,(s[0].get(0))));
               s[2] = temp2;
            }else{
               min = Integer.MAX_VALUE;
               for(int i=0; i < s[1].size();i++){
                   min = Math.min(min,help(i,s[1],tabla1)+g.getWeight((s[1].get(i)),(s[0].get(0))));
               }
               List<Integer> temp2 = new LinkedList();
               temp2.add(min);
               s[2] = temp2; 
           }
       }
       
       /*for(List<Integer>[] s : tabla1){
           for(int i = 0; i < 3; i++){
              System.out.print(s[i]); 
           }
           System.out.println();
       }*/
        return min;
    }
    
    public static List<List<Integer>> generarSubCon(int n) {
        int input[] = new int[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        List<List<Integer>> subConj = new LinkedList();
        int result[] = new int[input.length];
        generarSubCon(input, 0, 0, subConj, result);
        Collections.sort(subConj, new ListSizeComparator());
        return subConj;
    }

    private static void generarSubCon(int input[], int start, int pos, List<List<Integer>> subConj, int result[]) {
        if(pos == input.length+1) {
            return;
        }
        List<Integer> list = createList(result, pos);
        subConj.add(list);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generarSubCon(input, i+1, pos+1, subConj, result);
        }
    }

    private static List<Integer> createList(int input[], int pos) {
        if(pos == 0) {
            return new LinkedList();
        }
        List<Integer>list = new LinkedList();
        for(int i = 0; i < pos; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    private static int help (int i, List<Integer> list, List<List<Integer>[]> tabla1){
        List s0 = new LinkedList();
        s0.add(list.get(i));
        List s1 =  new LinkedList(list);
        s1.remove(i);
        for(List<Integer>[] s : tabla1){
            if(s0.equals(s[0]) && s1.equals(s[1]))
                return s[2].get(0);
        }
        return 0;
    }
      private static class ListSizeComparator implements Comparator<List<Integer>>{
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.size() - o2.size();
        }
    }
}
