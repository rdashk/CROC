CROC_Java

1. Написать программу, которая выводит на экран числа от 1 до 100. 
При этом вместо чисел, кратных трем, программа должна выводить слово «Fizz», 
а вместо чисел, кратных пяти — слово «Buzz». 
Если число кратно и 3, и 5, то программа должна выводить слово «FizzBuzz».

2. Необходимо разработать музыкальную систему:
-существуют несколько звуковоспроизводящих устройств (виниловая вертушка, сд, универсальный плеер и т.д.);
-существует несколько носителей музыкальных композиций (пластинка, сд, флешка и т.д);
-существуют несколько песен, у которых есть имя исполнителя (группы) и название.
Звуковоспроизводящее устройство должно выводить в консоль информацию о том, что за устройство воспроизводит песню, ее исполнителя и название. 
В случае, если устройство не может воспроизвести музыку с требуемого носителя выводить соответствующее сообщение.

3. Определить класс, описывающий координаты шахматной клетки. 
Данные класса: компоненты x и y, отсчитываемые от левого нижнего угла. 
Все методы, позволяющие установить координаты, в том числе и конструкторы, 
должны проверять корректность аргументов и генерировать IllegalArgumentException в случае ошибочных значений.
Переопределить метод toString(), выводящий координаты клетки в формате 
<номер колонки в виде буквы от 'a' до 'h'>
<номер строки, начиная с 1>. 
Например, клетка с координатами (1, 1) имеет строковое представление "b2".

4. 

5. Посчитать количество пробелов в строке, используя метод 
Matcher.match(String str, String character)
Метод возвращает true в случае обнаружения в строке str символа character.
Параметры:  str – строка в которой ищется символ, 
            character – искомый символ

6. В виде строки задан относительный путь в файловой системе, в котором:
"." означает текущую директорию;
".." означает родительскую директорию по отношению к текущей;
"/" используется в качестве разделителя директорий.
Реализовать функцию, выполняющую "нормализацию" заданного пути, то есть, удаляющую из него лишние директории с учетом переходов "." и "..".
