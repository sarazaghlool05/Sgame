import java.util.List;

public class PrintingResults {
    public String ValidCase(){
        return "VALID";
    }
    public String InvalidCase(List<Duplicate> duplicates){
        StringBuilder Reason=new StringBuilder();
        Reason.append("INVALID\n");
        String Type="";
        for(int i=0; i<duplicates.size();i++){
            Duplicate R=duplicates.get(i);
            String t=R.getType();
            int index=R.getIndex();
            int number=R.getValue();
            List<Integer> place=R.getPositions();
            if(!Type.equals("")&&!Type.equals(t)){
                Reason.append("--------------------------------\n");
            }
            Reason.append(t+""+(index+1)+" ,#"+number+", "+place.toString()+"\n");
            Type=t;
        }
        return Reason.toString();


    }
}
