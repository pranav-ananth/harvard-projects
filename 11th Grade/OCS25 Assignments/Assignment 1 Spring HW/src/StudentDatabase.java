import java.util.*;

public class StudentDatabase {

    private LinkedList<StudentAccount> records;
    private HashMap<String, StudentAccount> idTable;
    private HashMap<String, StudentAccount> compositeTable;

    public StudentDatabase() {
        records = new LinkedList<>();
        idTable = new HashMap<>();
        compositeTable = new HashMap<>();
    }

    public void addRecord(StudentAccount student) {
        StudentAccount byId = idTable.get(student.getStudentId());
        StudentAccount byComposite = compositeTable.get(student.getCompositeKey());

        if (byId == null && byComposite == null) {
            records.add(student);
            idTable.put(student.getStudentId(), student);
            compositeTable.put(student.getCompositeKey(), student);
        }
        else if (byId != null && byComposite != null && byId == byComposite) {
            byId.setData(student.toString());
        }
        else {
            throw new IllegalStateException(
                    "Error: only one key matches or keys match different records"
            );
        }
    }

    public void removeRecord(StudentAccount student) {
        records.remove(student);
        idTable.remove(student.getStudentId());
        compositeTable.remove(student.getCompositeKey());
    }

    public List<StudentAccount> getByName(String name) {
        List<StudentAccount> result = new ArrayList<>();
        String search = name.toLowerCase();

        for (StudentAccount s : records) {
            if (s.getFirstName().toLowerCase().contains(search) ||
                    s.getLastName().toLowerCase().contains(search)) {
                result.add(s);
            }
        }
        return result;
    }

    public StudentAccount getByStudentId(String id) {return idTable.get(id);}
    public StudentAccount getByCompositeKey(String compositeKey) {return compositeTable.get(compositeKey);}

    public void printAll() {
        for (StudentAccount s : records) {
            System.out.println(s);
        }
    }
}
