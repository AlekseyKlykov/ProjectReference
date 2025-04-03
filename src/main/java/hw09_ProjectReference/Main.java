package hw09_ProjectReference;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PetsDAO petsDAO =  new PetsDAO();
        Pets pets = petsDAO.getById(1009);

        long startTime = System.currentTimeMillis();

pets = petsDAO.getById(1011);



        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(pets.getName()+" Time select data without cache: "+duration+" ms");
        startTime =  System.currentTimeMillis();

        pets = petsDAO.cacheGetById(1010);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;

        System.out.println(pets.getName()+" Time first select data with cache: "+duration+" ms");

        startTime =  System.currentTimeMillis();
        pets = petsDAO.cacheGetById(1010);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;

        System.out.println(pets.getName()+" Time second select data with cache: "+duration+" ms");


    }
}