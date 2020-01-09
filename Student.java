class Student {
    private String name;
    private Mark mark;

    public Student(String n, Mark m) {
        name = n;
        mark = m;
    }

    public String getData() {
        String data = String.format("%1$-40s %2$20d\t%3$d%n", name, mark.getCourseWork(), mark.getFinalExam());
        return data; 
    }

    public String getResult() {
        String result = String.format("%1$-40s %2$20d\t%3$s%n", name, mark.getTotal(), mark.getGrade());
        return result;
    }

    public void printData() {
        System.out.printf("%1$-40s %2$20d\t%3$d%n", name, mark.getCourseWork(), mark.getFinalExam());
    }

    public void printResult() {
        System.out.printf("%1$-40s %2$20d\t%3$s%n", name, mark.getTotal(), mark.getGrade());
    }
}