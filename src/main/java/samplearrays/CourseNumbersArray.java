package samplearrays;

public class CourseNumbersArray {
    /**
     * adds a new course number to the existing array of registered courses
     * @param registredCourses : the original array
     * @param newCourseNumber : the new course to add
     * @return  : a new larger and updated array
     */
    public static int[] addNewCourse(int[] registredCourses, int newCourseNumber){
        int[] updatedCourses = new int[registredCourses.length + 1];
        for ( int i = 0; i < registredCourses.length; i++){
            updatedCourses[i] = registredCourses[i];
        }
        updatedCourses[registredCourses.length] = newCourseNumber;
        return updatedCourses;
    }

    /**
     * display the contents of an array
     * @param arr : the array to display
     */
    public static void display(int[] arr){
        for(int i = 0; i< arr.length - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1 ]);
    }

    /**
     *
     * @param arr : the array
     * @param course : the course number to search for
     * @return true if the array contains the course number, otherwise false
     */
    public static boolean isCourseInArray(int[] arr, int course){
        for( int element : arr){
            if (element == course){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print("Content of the initial registered Courses array : ");
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        display(registeredCourses);
        System.out.print("Content of the new updated Courses array : ");
        int[] updatedCourses = addNewCourse(registeredCourses,3100);
        display(updatedCourses);
        int courseNumber = 2500;
        System.out.println("Is Course" + courseNumber + " in the updated courses array : " + isCourseInArray(updatedCourses,courseNumber));
    }
}
