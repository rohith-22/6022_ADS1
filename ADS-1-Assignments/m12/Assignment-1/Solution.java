import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for student information.
 */
class StudentInformation {
  /**
   * student name.
   */
  private String studentName;
  /**
   * date of birth.
   */
  private String dateOfBirth;
  /**
   * subject marks one.
   */
  private int subjectOne;
  /**
     * subject marks two.
     */
  private int subjectTwo;
  /**
     * subject marks three.
     */
  private int subjectThree;
  /**
     * subject marks total.
     */
  private int totalMarks;
  /**
     * string category.
     */
  private String category;
  /**
   * Constructs the object.
   *
   * @param      name         The name
   * @param      dob          The dob
   * @param      marks1       The marks 1
   * @param      marks2       The marks 2
   * @param      marks3       The marks 3
   * @param      total        The total
   * @param      reservation  The reservation
   */
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
  /**
   * comparator.
   */
  static Comparator<StudentInformation> studentComparator =
  new Comparator<StudentInformation>() {
    public int compare(final StudentInformation student1,
                       final StudentInformation student2) {
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
  /**
   * Gets the category.
   *
   * @return     The category.
   */
  public String getCategory() {
    return this.category;
  }
  /**
   * Gets the name.
   *
   * @return     The name.
   */
  public String getName() {
    return this.studentName;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return this.studentName + "," + this.totalMarks + "," + this.category;
  }
}
/**
 * List of students.
 */
class StudentList {
  /**
   * array of list.
   */
  private StudentInformation[] list;
  /**
   * size variable.
   */
  private int size;
  /**
   * Constructs the object.
   *
   * @param      qualifiedStudents  The qualified students
   */
  StudentList(final int qualifiedStudents) {
    list = new StudentInformation[qualifiedStudents];
    size = 0;
  }
  /**
   * Adds a student.
   *
   * @param      object  The object
   */
  public void addStudent(final StudentInformation object) {
    list[size++] = object;
  }
  /**
   * Gets the list.
   *
   * @return     The list.
   */
  public StudentInformation[] getList() {
    return list;
  }
}
/**
 * Class for sort.
 */
class Sort {
  /**
   * Constructs the object.
   */
  Sort() {


  }
  /**
   * insertion sorting.
   *
   * @param      studentList  The student list
   * @param      comparator   The comparator
   */
  public static void sort(final Object[] studentList,
                          final Comparator comparator) {
    int n = studentList.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (less(comparator, studentList[j], studentList[min])) {
          min = j;
        }
      }
      exch(studentList, i, min);
    }
  }
  /**
   * compares the objecst.
   *
   * @param      comparator  The comparator
   * @param      v           object
   * @param      w           object
   *
   * @return     boolean
   */
  private static boolean less(final Comparator comparator,
                              final Object v, final Object w) {
    return comparator.compare(v, w) < 0;
  }
  /**
   * excahnge functin exchanges the two elements.
   *
   * @param      studentList  The student list
   * @param      i            object
   * @param      j            object
   */
  private static void exch(final Object[] studentList,
                           final int i, final int j) {
    Object swap = studentList[i];
    studentList[i] = studentList[j];
    studentList[j] = swap;
  }
  /**
   * gives decending order of array.
   *
   * @param      arr    The arr
   * @param      strt  The start
   * @param      eend    The end
   */
  public static void decendingOrder(final StudentInformation[] arr,
                                    final int strt, final int eend) {
    StudentInformation temp;
    int start = strt;
    int end = eend;
    while (start < end) {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

}
/**
 * main solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main sfuntion to handlse inpuit and output.
   *
   * @param      args  The arguments
   */
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
      final int three = 3, four = 4, five = 5, six = 6;
      objectList.addStudent(new StudentInformation(tokens[0], tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[three]),
                            Integer.parseInt(tokens[four]),
                            Integer.parseInt(tokens[five]),
                            tokens[six]));
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
  /**
   * seat alocation to alocate seates.
   *
   * @param      listOfStudents  The list of students
   * @param      totalVacancies  The total vacancies
   * @param      openVacancies   The open vacancies
   * @param      bcVacancies     The bc vacancies
   * @param      scVacancies     The screen vacancies
   * @param      stVacancies     The st vacancies
   */
  public static void seatAlocation(final StudentInformation[] listOfStudents,
                                   final int totalVacancies,
                                   final int openVacancies,
                                   final int bcVacancies, final int scVacancies,
                                   final int stVacancies) {
    StudentInformation[] meritList = new StudentInformation[totalVacancies];
    int openCatogery = openVacancies;
    int bcCatogery = bcVacancies;
    int scCatogery = scVacancies;
    int stCatogery = stVacancies;
    int size = 0;
    for (int i = 0; i < listOfStudents.length; i++) {
      if (openCatogery != 0) {
        meritList[size++] = listOfStudents[i];
        openCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("BC")
          && bcCatogery != 0 &&  i > size) {
        meritList[size++] = listOfStudents[i];
        bcCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("SC")
          && scCatogery != 0 &&  i > size) {
        meritList[size++] = listOfStudents[i];
        scCatogery--;
      }
      if (listOfStudents[i].getCategory().equals("ST")
          && stCatogery != 0 &&  i > size) {
        meritList[size++] = listOfStudents[i];
        stCatogery--;
      }
    }
    // System.out.println(size);
    // if () {
      for (StudentInformation each : listOfStudents) {
        for (int l = 0; l < meritList.length; l++) {
          if (!each.getName().equals(meritList[l].getName()) && size <= meritList.length) {
            meritList[size++] = each;
            break;
          }
        }
      }
    // }
    for (int k = 0; k < meritList.length; k++) {
      System.out.println(meritList[k]);
    }

  }
}
