
#include "Vector.hpp"
#include <gtest/gtest.h>
#include <stdatomic.h>

TEST(VECTOR_SYSTEM_TEST, VectorConstructor) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    ASSERT_EQ(vec.GetSize(), 3);
    ASSERT_EQ(vec.GetCapacity(), 4);
    ASSERT_EQ(vec.At(0), 1);
    ASSERT_EQ(vec.At(1), 2);
    ASSERT_EQ(vec.At(2), 3);
}

TEST(VECTOR_SYSTEM_TEST, VectorSize) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    ASSERT_EQ(vec.GetSize(), 3);
}

TEST(VECTOR_SYSTEM_TEST, VectorCapacity) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    ASSERT_EQ(vec.GetCapacity(), 4);
}

TEST(VECTOR_SYSTEM_TEST, VectorAt) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    ASSERT_EQ(vec.At(0), 1);
    ASSERT_EQ(vec.At(1), 2);
    ASSERT_EQ(vec.At(2), 3);
}

TEST(VECTOR_SYSTEM_TEST, VectorUpdateAt) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    vec.UpdateAt(0, 1);
    vec.UpdateAt(1, 2);
    vec.UpdateAt(2, 3);

    ASSERT_EQ(vec.At(0), 1);
    ASSERT_EQ(vec.At(1), 2);
    ASSERT_EQ(vec.At(2), 3);
}

TEST(VECTOR_SYSTEM_TEST, VectorRemoveAt) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);

    vec.RemoveAt(1);

    ASSERT_EQ(vec.GetSize(), 2);
    ASSERT_EQ(vec.GetCapacity(), 4);
    ASSERT_EQ(vec.At(0), 1);
    ASSERT_EQ(vec.At(1), 3);
}

TEST(VECTOR_SYSTEM_TEST, VectorInsertAt) {
    Vector vec;

    vec.Append(1);
    vec.Append(2);
    vec.Append(3);
    vec.Append(4);

    vec.InsertAt(1, 5);

    ASSERT_EQ(vec.GetSize(), 5);
    ASSERT_EQ(vec.GetCapacity(), 8);
    ASSERT_EQ(vec.At(0), 1);
    ASSERT_EQ(vec.At(1), 5);
    ASSERT_EQ(vec.At(2), 2);
    ASSERT_EQ(vec.At(3), 3);
    ASSERT_EQ(vec.At(4), 4);
}

TEST(VECTOR_SYSTEM_TEST, VectorJoin) {
    Vector vec1;
    Vector vec2;

    vec1.Append(1);
    vec1.Append(2);
    vec1.Append(3);

    vec2.Append(4);
    vec2.Append(5);
    vec2.Append(6);

    vec1.Join(vec2);

    ASSERT_EQ(vec1.GetSize(), 6);
    ASSERT_EQ(vec1.At(0), 1);
    ASSERT_EQ(vec1.At(1), 2);
    ASSERT_EQ(vec1.At(2), 3);
    ASSERT_EQ(vec1.At(3), 4);
    ASSERT_EQ(vec1.At(4), 5);
    ASSERT_EQ(vec1.At(5), 6);
}

TEST(VECTOR_SYSTEM_TEST, VectorTHROWOUT) {
    Vector vec;

    vec.Append(1);

    ASSERT_THROW(vec.At(1), std::out_of_range);
}