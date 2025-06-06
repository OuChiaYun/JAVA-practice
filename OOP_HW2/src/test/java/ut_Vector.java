import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ut_Vector {
    @Test
    public void vector_system_test_VectorConstructor() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        assertThat(vec.GetSize()).matches(q -> q == 3);
        assertThat(vec.GetCapacity()).matches(q -> q == 4);
        assertThat(vec.At(0)).matches(q -> q == 1);
        assertThat(vec.At(1)).matches(q -> q == 2);
        assertThat(vec.At(2)).matches(q -> q == 3);

    }

    @Test
    public void vector_system_test_VectorSize() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        assertThat(vec.GetSize()).matches(q -> q == 3);
    }

    @Test
    public void vector_system_test_VectorCapacity() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        assertThat(vec.GetCapacity()).matches(q -> q == 4);
    }

    @Test
    public void vector_system_test_VectorAt() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        assertThat(vec.At(0)).matches(q -> q == 1);
        assertThat(vec.At(1)).matches(q -> q == 2);
        assertThat(vec.At(2)).matches(q -> q == 3);
    }

    @Test
    public void vector_system_test_VectorUpdateAt() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        vec.UpdateAt(0, 1);
        vec.UpdateAt(1, 2);
        vec.UpdateAt(2, 3);

        assertThat(vec.At(0)).matches(q -> q == 1);
        assertThat(vec.At(1)).matches(q -> q == 2);
        assertThat(vec.At(2)).matches(q -> q == 3);

    }

    @Test
    public void vector_system_test_VectorRemoveAt() {

        Vector vec = new Vector();

        vec.Append(1);
        vec.Append(2);
        vec.Append(3);

        vec.RemoveAt(1);

        assertThat(vec.GetSize()).matches(q -> q == 2);
        assertThat(vec.GetCapacity()).matches(q -> q == 4);
        assertThat(vec.At(0)).matches(q -> q == 1);
        assertThat(vec.At(1)).matches(q -> q == 3);

    }

    @Test
    public void vector_system_test_VectorJoin() {

        Vector vec1 = new Vector();
        Vector vec2 = new Vector();

        vec1.Append(1);
        vec1.Append(2);
        vec1.Append(3);
        vec2.Append(4);
        vec2.Append(5);
        vec2.Append(6);

        vec1.Join(vec2);

        assertThat(vec1.GetSize()).matches(q -> q == 6);
        assertThat(vec1.At(0)).matches(q -> q == 1);
        assertThat(vec1.At(1)).matches(q -> q == 2);
        assertThat(vec1.At(2)).matches(q -> q == 3);
        assertThat(vec1.At(3)).matches(q -> q == 4);
        assertThat(vec1.At(4)).matches(q -> q == 5);
        assertThat(vec1.At(5)).matches(q -> q == 6);
    }

    @Test
    public void vector_system_test_VectorTHROWOUT() {

        Vector vec = new Vector();

        vec.Append(1);

        Throwable thrown = catchThrowable(() -> {
            vec.At(1);
        });
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Index out of range.");

    }

}
