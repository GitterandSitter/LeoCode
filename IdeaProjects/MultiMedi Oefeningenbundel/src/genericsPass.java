class genericsRefactor<Object>{

   /*
   Refactor-class accepting an array of any type, converting it to a generic array of Object-type.
   Pass-class requesting a Monster array and casting it to the Object type. All functional.
   Passed in array, however is of type Monster (not Array). Selection through index seems impossible.
   Workaround by letting a Monster be returned from RMED would surpass the goal of the exercise.
    */
    Object[] objects;
    genericsRefactor(Object[] object) {
        this.objects = object;
    }

    public Object getObjectFromArray(int index) {
        return (Object) this.objects[index].toString();
    }
}

public class genericsPass {
    public static void main(String[] args){
        genericsRefactor<Monster> genericObject = new genericsRefactor<Monster>(RandomMonsterEncounterDemo.returnMonsterArray());
        System.out.println(genericObject.getObjectFromArray(0));
        //System.out.println(RandomMonsterEncounterDemo.returnMonsterArray().getClass());

    }
}

    /*// We use < > to specify Parameter type
    class Test<T> {
        // An object of type T is declared
        T obj;
        Test(T obj) { this.obj = obj; } // constructor
        public T getObject() { return this.obj; }
    }

    // Driver class to test above
    class Main {
        public static void main(String[] args)
        {
            // instance of Integer type
            Test<Integer> iObj = new Test<Integer>(15);
            System.out.println(iObj.getObject());

            // instance of String type
            Test<String> sObj
                    = new Test<String>("GeeksForGeeks");
            System.out.println(sObj.getObject());
        }
    }*/

