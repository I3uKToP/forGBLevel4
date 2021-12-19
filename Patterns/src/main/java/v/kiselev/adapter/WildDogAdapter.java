package v.kiselev.adapter;

public class WildDogAdapter implements Lion{
    private WildDog wildDog;

    public WildDogAdapter(WildDog wildDog) {
        this.wildDog = wildDog;
    }

    @Override
    public void roar() {
        this.wildDog.bark();
    }
}
