import java.util.Arrays;

public class Vector {

    private int m_Size = 0; // 當中資料所佔的筆數
    private int m_Capacity = 0; // 當中資料所能容納的最大筆數

    private int[] m_Data = new int[0];

    public Vector() {
        m_Size = 0;
        m_Capacity = 1;
        this.m_Data = Arrays.copyOf(this.m_Data, this.m_Capacity * 2);

    };

    public Vector(Vector other) {
        this.m_Size = other.m_Size;
        this.m_Capacity = other.m_Size;
        this.m_Data = Arrays.copyOf(other.m_Data, other.GetSize());
    };

    public int GetSize() {
        return this.m_Size;
    };

    public int GetCapacity() {
        return this.m_Capacity;
    };

    public int At(int index) {
        if (index < 0 || index > this.m_Size - 1) {
            throw new IllegalArgumentException("Index out of range.");
        } else {
            return this.m_Data[index];
        }
    };

    public void Append(int value) {
        if (this.m_Size >= this.m_Capacity) {
            this.m_Data = Arrays.copyOf(this.m_Data, this.m_Capacity * 2);
        }
        m_Data[this.m_Size] = value;
        m_Size++;
        m_Capacity = this.m_Data.length;

    };

    public void UpdateAt(int index, int value) {
        this.m_Data[index] = value;
    };

    public void RemoveAt(int index) {
        for (int i = index; i < m_Size; i++) {
            this.m_Data[i] = m_Data[i + 1];
        }
        this.m_Size--;
    };

    public void Join(Vector other) {

        int tmp = this.m_Capacity;

        if ((this.m_Size + other.m_Size) > tmp) {

            while (this.m_Size + other.m_Size > tmp) {
                tmp *= 2;
            }

            this.m_Data = Arrays.copyOf(this.m_Data, tmp);
            System.arraycopy(other.m_Data, 0, this.m_Data, this.m_Size, other.m_Size);
        } else {
            System.arraycopy(other.m_Data, 0, this.m_Data, this.m_Size + 1, other.m_Size);

        }
        this.m_Capacity = tmp;
        this.m_Size = this.m_Size + other.m_Size;

    };
}
