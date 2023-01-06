package be.multimedi.hellolib;
   
   import be.multimedi.hellolib.helpers.HelloHelper;

   public class Hello {
      private HelloHelper helper = new HelloHelper();

      public String sayHello(String name) {
         return helper.createHelloResponse(name);
      }
   }