package com.geekhub.homeworks;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class CollectionUtils {


        private CollectionUtils() {
        }


        static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
            //TODO Implement me
            List<E> value = new ArrayList<>();
            for (E element : elements){
                if (!filter.equals(element)){
                    value.add(element);
                }
            }
            return value;
        }


        static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
            //TODO Implement me
            for (E element : elements){
                if (predicate.equals(element)){
                    return true;
                }
            }
            return false;
        }


        static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
            //TODO Implement me
            for (E element : elements){
                if(!predicate.equals(element)){
                    return true;
                }
            }
            return false;
        }


        static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
            //TODO Implement me
            for (E element : elements){
                if (predicate.test(element)){
                    return false;
                }
            }
            return true;
        }


        static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
            //TODO Implement me
            List<R> value = new ArrayList<>();
            for (T list : elements){
                value.add(mappingFunction.apply(list));
            }
            return value;
        }


        static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
            //TODO Implement me
                E maxValue = elements.get(0);
            int i=0;
            while (i<=elements.size()) {
                maxValue = comparator.compare(maxValue,elements.get(i))>0? maxValue :elements.get(i);
                i++;
            }
            return Optional.of(maxValue);
        }

        static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
            //TODO Implement me
            E minValue = elements.get(0);
            for (E element : elements) {
                minValue = comparator.compare(minValue, element) < 0 ? minValue : element;
            }
            return Optional.of(minValue);
        }

        static <E> List<E> distinct(List<E> elements) {
            //TODO Implement me
            List<E> value = new ArrayList<>();
            for (E element:elements){
                if (!value.contains(element)){
                    value.add(element);
                }
            }
            return value;
        }

        static <E> void forEach(List<E> elements, Consumer<E> consumer) {
            //TODO Implement me
            elements.forEach(consumer);
        }

        static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
            //TODO Implement me
            E value = elements.get(0);
            for (E element : elements) {
                value = accumulator.apply(value, element);
            }
            return Optional.of(value);
        }


        static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
            //TODO Implement me
            E value =seed;
            for (E element : elements) {
                value = accumulator.apply(value, element);
            }
            return value;
        }

        static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
            //TODO Implement me
            Map<Boolean, List<E>> map = new HashMap<>();
            List<E> trueList = new ArrayList<>();
            List<E> falseList = new ArrayList<>();
            for (E element : elements){
                if (predicate.test(element)){
                    trueList.add(element);
                }
                else falseList.add(element);
            }
            map.replace(true, trueList);
            map.replace(false, falseList);
            return map;
        }


        static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
            //TODO Implement me
            Map<K, List<T>> map = new HashMap<>();
            List<T> list = new ArrayList<>();
            for (T element : elements){
                K value = classifier.apply(element);
                if (map.containsKey(value)){
                    map.get(value).add(element);
                }
                else{
                    list.add(element);
                    map.put(value,list);
                }
            }
            return map;
        }


        static <T, K, U> Map<K, U> toMap(List<T> elements,
                                         Function<T, K> keyFunction,
                                         Function<T, U> valueFunction,
                                         BinaryOperator<U> mergeFunction) {
            //TODO Implement me
            Map<K,U> map = new HashMap<>();
            K key;
            U value;
            for (T element:elements){
                key = keyFunction.apply(element);
                value = valueFunction.apply(element);
                if (map.containsKey(key)){
                    map.put(key,mergeFunction.apply(map.get(key),value));
                }
                else {
                    map.put(key,value);
                }
            }
            return map;
        }
    }


