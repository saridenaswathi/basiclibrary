package com.libtest.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
@ComponentScan("com.libtest.spring")
public class Application {

//    public  int evenSum(int arr[]){
//        int eSum =0;
//        for(int i=0;i< arr.length; i++){
//            if(arr[i]%2 == 0)
//                eSum = eSum+arr[i];
//        }
//        return eSum;
//    }


   /* public static void testIteration(){
        int[][] ff = {{2,3,4,5},{6,5,7,8,9},{22,34,56,66,78,88}};
        System.out.println("length:"+ff.length);
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        for (Integer i : x) {
            System.out.println(i);
        }
        x.forEach(System.out::println);
        Iterator itr = x.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());


        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Integer> s2 = new TreeSet<>();
        s2.add(1);
        s2.add(2);
        s2.add(3);

        for (Integer i : s1)
            System.out.println(i);
        s1.forEach(System.out::println);
        s2.forEach(System.out::println);

        itr = s1.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        itr = s2.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        Map<Integer,Integer> m1 = new HashMap<>();
        m1.put(1,1);
        m1.put(2,2);
        Map<Integer,Integer> m2 = new TreeMap<>();
        m2.put(1,11);
        m2.put(2,22);
        m2.put(3,33);
        m2.put(4,44);
        m1.forEach((k,v) -> System.out.println("k :"+k+" v :"+v));

        Iterator<Map.Entry<Integer,Integer>> mapItr = m2.entrySet().iterator();
        while(mapItr.hasNext()) {
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer, Integer>) mapItr.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println("Test map: "+m2.values().stream().reduce(0,(v1,v2) -> v1+v2));

         System.out.println("SUm :::: "+m2.entrySet().stream()
                .filter( p -> p.getKey()%2 == 0)
                 .map( p -> p.getValue())
                 .reduce( 0,(p,y) -> p+y));
                //.collect(Collectors.toCollection(ArrayList::new))
                //.forEach(System.out::println);

         //set from map
        Set<Map.Entry<Integer,Integer>> entrySet = m1.entrySet();
        //set of keys
        Set<Integer> keySet = m1.keySet();
        //Collection of values
        Collection<Integer> c = m1.values();
    }*/

    public static void main(String args[]){
        /*int[] arr = {1,3,5,7};
        evenSum(arr);
        System.out.println(Arrays.stream(arr).filter(t -> t%2==0).reduce(0,(a,b) -> a*b));*/
        //testIteration();

        SpringApplication.run(Application.class, args);
    }
}
