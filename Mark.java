class Mark {
    private int course_work;
    private int final_exam;

    public Mark(int cw, int fe) {
        course_work = cw;
        final_exam = fe;
    }

    public int getCourseWork() {
        return course_work;
    }

    public int getFinalExam() {
        return final_exam;
    }

    public int getTotal() {
        return course_work+final_exam;
    }

    public String getGrade() {
        int total = getTotal();
        if(total >= 90)
            return "A+";
        else if(total >= 80)
            return "A";
        else if(total >= 75)
            return "A-";
        else if(total >= 70)
            return "B+";
        else if(total >= 65)
            return "B";
        else if(total >= 60)
            return "B-";
        else if(total >= 55)
            return "C+";
        else if(total >= 50)
            return "C";
        else if(total >= 45)
            return "C-";
        else if(total >= 40)
            return "D";
        else if(total >= 35)
            return "E";
        return null;
    }
}