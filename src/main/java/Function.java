public class Function {

    Function(){
    }

    /**
     * @param a int
     * @param b long
     *          в различных комбинациях
     *          (int, int) (int, long) (long, int) (long, long)
     * @return данные типа java.lang.Integer или Void
     *
     * @throws UserException при некорректном типе данных
     *  текст сообщения: "Error data type"
     *
     */
    public Object procedure(Object a, Object b){
        int tempInt = 1;
        long tempLong = 0L;

        try {
            if (getName(a).equals(getName(tempInt)) && getName(b).equals(getName(tempLong))) {
                return 1;
            }
            if (getName(a).equals(getName(tempLong)) && getName(b).equals(getName(tempInt))) {
                return new Void();
            }
            if (getName(a).equals(getName(tempInt)) && getName(b).equals(getName(tempInt))){
                return 1;
            }
            if (getName(a).equals(getName(tempLong)) && getName(b).equals(getName(tempLong))){
                return new Void();
            }
            throw new UserException("Error data type", new Exception());
        } catch (UserException e) {
            e.printStackTrace();
        }
        return null;
    }

    String getName(Object a){
        return a.getClass().getCanonicalName();
    }

}
