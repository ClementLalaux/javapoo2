package org.example;

import org.example.Book.*;
import org.example.Collections.CercleDemo;
import org.example.Collections.ListDemo;
import org.example.Enum.EnumUn;
import org.example.Exercice1.Chaises;
import org.example.Exercice6.Door;
import org.example.Exercice6.House;
import org.example.Exercice6.Person;
import org.example.ExoStream.Course;
import org.example.ExoStream.Student;
import org.example.ExoStream.Teacher;
import org.example.Recursive.factoriel;
import org.example.Recursive.factorielDeux;
import org.example.Recursive.multiplie;
import org.example.Stream.Trader;
import org.example.Stream.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */


public class App
{
    public static void main( String[] args )
    {
        /*Auteur auteur1 = new Auteur("Jon", "Johnson");
        Editeur editeur1 = new Editeur("Publisher_1");

        Book[] livres = new Book[] {
                new Book( "Book_1", new Auteur[] { auteur1 }, editeur1, 1990, 231, 24.99, CoverType.Broché),
                new Book( "Book_2", new Auteur[] { auteur1 , new Auteur("William", "Wilson") }, new Editeur( "Publisher_2 "), 2000, 120, 14.99, CoverType.Broché),
                new Book( "Book_4",new Auteur[]{new Auteur( "Walter", "Peterson") }, new Editeur( "Publisher_1"), 1997, 350, 34.99, CoverType.Relié),
                new Book("Book_4", new Auteur[] { new Auteur( "Craig", "Gregory") }, new Editeur( "Publisher_3"), 1992, 185, 19.99, CoverType.Broché) };

        BookService bookService = new BookService();

        for (Book book : bookService.filterBooksByAuthor(auteur1,livres)) {
            System.out.println(book.getName());
        }

        for (Book book : bookService.filterBooksByPublisher(editeur1,livres)) {
            System.out.println(book.getName());
        }

        for (Book book : bookService.filterBooksByYears(1993,livres)) {
            System.out.println(book.getName());
        }*/

        //ListDemo.main();

        //CercleDemo.main();

        /*Trader abdallah = new Trader("Abdallah","Cambridge");
        Trader audrey = new Trader("Audrey","Milan");
        Trader corentin = new Trader("Corentin","Cambridge");
        Trader tristan = new Trader("Tristan","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(abdallah,2011,500),
                new Transaction(abdallah,2012,300),
                new Transaction(corentin,2012,710),
                new Transaction(corentin,2012,700),
                new Transaction(audrey,2012,1000),
                new Transaction(audrey,2011,400),
                new Transaction(tristan,2012,950),
                new Transaction(tristan,2022,900)
        );

        transactions.stream().filter(t -> t.getYear() == 2011).sorted(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getValue()-o2.getValue();
            }
        }).forEach(System.out::println);

        List<String> villes = new ArrayList<>();

        villes = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());

        transactions.stream().map(transaction -> transaction.getTrader()
                .getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println(villes.stream().anyMatch(v-> v == "Milan"));

        System.out.println(transactions.stream().map(e->e.getValue()).max(Integer::compare).get());

        System.out.println("------------------------");

        List<Trader> traderCambridge = new ArrayList<>();

        traderCambridge = transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(v->v.getTrader()).sorted(new Comparator<Trader>() {
                    @Override
                    public int compare(Trader o1, Trader o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }).distinct().collect(Collectors.toList());

        System.out.println(traderCambridge);

        List<Integer> listTransactionCambrige = new ArrayList<>();

        listTransactionCambrige = transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(v-> v.getValue()).collect(Collectors.toList());

        System.out.println(transactions.stream().map(transaction -> transaction.getValue()).min(Integer::compare));*/


        Teacher teacher1 = new Teacher(1,"John Doe","Mathematics",2010);
        Teacher teacher2 = new Teacher(2,"Jane Smith","Physics",2015);
        Teacher teacher3 = new Teacher(3,"Michael Johnson","Chemistry",2005);
        Teacher teacher4 = new Teacher(4,"Michel Papin","Informatique",2003);

        Course course1 = new Course(1,"Calculus",teacher1,15);
        Course course2 = new Course(2,"Mechanics",teacher2,10);
        Course course3 = new Course(3,"Organic Chemistry",teacher3,12);
        Course course4 = new Course(4,"Java",teacher4,12);

        Student student1 = new Student(1,"Alice",18);
        Student student2 = new Student(2,"Bob",20);
        Student student3 = new Student(3,"Charlie",19);
        Student student4 = new Student(4,"David",21);
        Student student5 = new Student(5,"Eve",22);

        student1.addCourses(course1);
        student1.addCourses(course2);

        student2.addCourses(course3);
        student2.addCourses(course1);

        student3.addCourses(course4);
        student3.addCourses(course3);
        student3.addCourses(course1);

        student4.addCourses(course3);
        student4.addCourses(course1);
        student4.addCourses(course2);
        student4.addCourses(course4);

        student5.addCourses(course1);
        student5.addCourses(course3);
        student5.addCourses(course2);

        List<Student> listStudent = new ArrayList<>();

        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        listStudent.add(student5);

        List<Teacher> listTeacher = new ArrayList<>();

        listTeacher.add(teacher1);
        listTeacher.add(teacher2);
        listTeacher.add(teacher3);
        listTeacher.add(teacher4);

        List<Course> listCourse = new ArrayList<>();

        listCourse.add(course1);
        listCourse.add(course2);
        listCourse.add(course3);
        listCourse.add(course4);


        listStudent.stream().filter(student -> student.getAge() > 20).map(student -> student.getName()).forEach(System.out::println);


        List<String> listNomTeacher = new ArrayList<>();

        listNomTeacher = listTeacher.stream().map(teacher -> teacher.getName()).collect(Collectors.toList());


        List<String> listTeacherMatiere = new ArrayList<>();

        listTeacherMatiere = listTeacher.stream().map(teacher -> teacher.getDepartement()).collect(Collectors.toList());


        List<Teacher> listTeacherViaCourse = new ArrayList<>();

        listTeacherViaCourse = listCourse.stream().map(course -> course.getTeacher()).collect(Collectors.toList());


        System.out.println(listCourse.stream().mapToDouble(course -> course.getDuration()).sum());


        List<Course> listCourseSupOnze = new ArrayList<>();

        listCourseSupOnze=listCourse.stream().filter(course -> course.getDuration()>11).sorted(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList());


        List<Course> listDeToutLesCoursesParEleve = new ArrayList<>();

        listDeToutLesCoursesParEleve = listStudent.stream().flatMap(student -> student.getCourses().stream()).collect(Collectors.toList());


        List<Course> listeQuestionDix = new ArrayList<>();

        listeQuestionDix = listStudent.stream().filter(student -> student.getAge()>=18 && student.getAge() <= 20)
                .flatMap(student -> student.getCourses().stream()).sorted(new Comparator<Course>() {
                    @Override
                    public int compare(Course o1, Course o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }).collect(Collectors.toList());


    }
}
