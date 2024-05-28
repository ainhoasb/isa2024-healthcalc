package healthcalc;

public class PersonImpl implements Person{
    private float weight;
    private float height;
    private Gender gender;
    private int age;

    public PersonImpl(float weight, float height, Gender gender, int age) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    //Un segundo constructor de persona en el caso que solo se calcule el peso ideal, ya que el usuario solo habrá introducido la altura y el género.
    public PersonImpl(float height, Gender gender) {
        this.height = height;
        this.gender = gender;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public float height() {
        return height;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public int age() {
        return age;
    }
    
}
