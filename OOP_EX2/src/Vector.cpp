
#include "Vector.hpp"

#include <algorithm>
#include <stdexcept>

Vector::Vector(const Vector &other)
    : m_Size(other.m_Size),
      m_Capacity(other.m_Capacity),
      m_Data(m_Capacity ? new int[other.m_Capacity] : nullptr) {
    std::copy(&other.m_Data[0], &other.m_Data[other.GetSize()], m_Data);
}

Vector::Vector(Vector &&other) noexcept //
    : Vector() {                        //
    swap(*this, other);
}

void swap(Vector &v1, Vector &v2) {
    std::swap(v1.m_Size, v2.m_Size);
    std::swap(v1.m_Capacity, v2.m_Capacity);
    std::swap(v1.m_Data, v2.m_Data);
}

Vector &Vector::operator=(const Vector &other) {
    Vector tmp(other);
    swap(*this, tmp);
    return *this;
}

Vector &Vector::operator=(Vector &&other) noexcept {
    swap(*this, other);
    return *this;
}

Vector::~Vector() {
    delete[] m_Data;
}

int Vector::GetSize() const {}

int Vector::GetCapacity() const {}

void Vector::Append(int value) {}

void Vector::InsertAt(int index, int value) {}

void Vector::UpdateAt(int index, int value) {}

void Vector::RemoveAt(int index) {}

int Vector::At(int index) const {}

void Vector::Join(const Vector &other) {}

void Vector::Resize() {}
