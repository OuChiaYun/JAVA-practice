public class SideDish extends Food {

    private SideDishType type = SideDishType.SMALL;

    public SideDish() {
    };

    public SideDish(Production id) {
    };

    public void MakeFood() {
    };

    public void MakeLarger() {
    };

    public SideDishType GetType() {
        return SideDishType.BIG;
    };

}

// final => C++ 此處將導致編譯錯誤
