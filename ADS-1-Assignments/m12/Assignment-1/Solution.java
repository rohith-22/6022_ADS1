import java.util.*;

class StudentInformation {
  private String studentName;

  private String dateOfBirth;

  private int subjectOne;

  private int subjectTwo;

  private int subjectThree;

  private int totalMarks;

  private String category;

  StudentInformation(final String name, final String dob,
                     final int marks1, final int marks2, final int marks3,
                     final int total, final String reservation) {
    this.studentName = name;
    this.dateOfBirth = dob;
    this.subjectOne = marks1;
    this.subjectTwo = marks2;
    this.subjectThree = marks3;
    this.totalMarks = total;
    this.category = reservation;
  }
  static Comparator<StudentInformation> studentComparator =
  new Comparator<StudentInformation>() {
    public int compare(StudentInformation student1, StudentInformation student2) {
      if (student1.totalMarks - student2.totalMarks != 0) {
        return student1.totalMarks - student2.totalMarks;
      }
      if (student1.subjectThree - student2.subjectThree != 0) {
        return student1.subjectThree - student2.subjectThree;
      }
      if (student1.subjectTwo - student2.subjectTwo != 0) {
        return student1.subjectTwo - student2.subjectTwo;
      }
      return student1.dateOfBirth.compareTo(student2.dateOfBirth);
    }
  };
  public String getCategory() {
    return this.category;
  }
  public String toString() {
    return this.studentName + "," + this.totalMarks + "," + this.category;
  }
}
class StudentList {
  private StudentInformation[] list ;
  private int size;
  StudentList(final int qualifiedStudents) {
    list = new StudentInformation[qualifiedStudents];
    size = 0;
  }
  public void addStudent(StudentInformation object) {
    list[size++] = object;
  }
  public StudentInformation[] getList() {
    return list;
  }
}
class Sort {
  Sort() {

  }
  public static void sort(final Object[] studentList, final Comparator comparator) {
    int n = studentList.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (less(comparator, studentList[j], studentList[min])) min = j;
      }
      exch(studentList, i, min);
    }
  }
  private static boolean less(final Comparator comparator,
                              final Object v, final Object w) {
    return comparator.compare(v, w) < 0;
  }
  private static void exch(final Object[] studentList, final int i, final int j) {
    Object swap = studentList[i];
    studentList[i] = studentList[j];
    studentList[j] = swap;
  }
  public static void decendingOrder(StudentInformation[] arr,
                                    int start, int end) {
    StudentInformation temp;

    while (start < end) {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

}

public final class Solution {
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int studentsQualified = sc.nextInt();
    StudentList objectList = new StudentList(studentsQualified);
    int totalVacancies = sc.nextInt();
    int openVacancies = sc.nextInt();
    int bcVacancies = sc.nextInt();
    int scVacancies = sc.nextInt();
    int stVacancies = sc.nextInt();
    for (int j = 0; j < studentsQualified; j++) {
      String[] tokens = sc.next().split(",");
      // System.out.println(Arrays.toString(tokens));
      objectList.addStudent(new StudentInformation(tokens[0], tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            tokens[6]));
    }
    StudentInformation[] listOfStudents = objectList.getList();
    Sort sortStudents = new Sort();
    sortStudents.sort(listOfStudents, StudentInformation.studentComparator);
    sortStudents.decendingOrder(listOfStudents, 0, listOfStudents.length - 1);
    for (int i = 0; i < listOfStudents.length; i++) {
      System.out.println(listOfStudents[i]);
    }
    System.out.println();
    seatAlocation(listOfStudents, totalVacancies,
                  openVacancies, bcVacancies, scVacancies, stVacancies);
  }
  public static void seatAlocation(final StudentInformation[] listOfStudents,
                                   final int totalVacancies, final int openVacancies,
                                   final int bcVacancies, final int scVacancies,
                                   final int stVacancies) {
    StudentInformation[] meritList = new StudentInformation[totalVacancies];
    int openCatogery = openVacancies;
    int bcCatogery = bcVacancies;
    int scCatogery = scVacancies;
    int stCatogery = stVacancies;
    int j = 0;
    for (int i = 0; i < listOfStudents.length; i++) {
      if (openCatogery != 0 ) {
        meritList[j++] = listOfStudents[i];
        openCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("BC")
          && bcCatogery != 0 &&  i > j) {
        meritList[j++] = listOfStudents[i];
        bcCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("SC")
          && scCatogery != 0 &&  i > j) {
        meritList[j++] = listOfStudents[i];
        scCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("ST")
          && stCatogery != 0 &&  i > j) {
        meritList[j++] = listOfStudents[i];
        stCatogery--;
      }
    }

    for (int k = 0; k < meritList.length; k++) {
      System.out.println(meritList[k]);
    }






















  }
}