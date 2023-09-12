//Создаем класс-родитель с общими своствами иметодами для всех участниковю
class Participant {
    protected String name;
    protected int runningLimit;
    protected int jumpingLimit;

    public Participant(String name, int runningLimit, int jumpingLimit) {
        this.name = name;
        this.runningLimit = runningLimit;
        this.jumpingLimit = jumpingLimit;
    }

    public void run(int distance) {
        if (distance <= runningLimit) {
            System.out.println(name + " успешно пробежал дистанцию");
        } else {
            System.out.println(name + " не смог пробежать дистанцию");
        }
    }

    public void jump(int height) {
        if (height <= jumpingLimit) {
            System.out.println(name + " успешно перепрыгнул через препятствие");
        } else {
            System.out.println(name + " не смог перепрыгнуть через препятствие");
        }
    }
}
// Сздаем дочерние классы "Человек", "Кот", "Робот".
//В каждом из дочерних классов определены конструкторы для инициализации свойств и 
//переопределены методы run и jump.
class Human extends Participant {
    public Human(String name, int runningLimit, int jumpingLimit) {
        super(name, runningLimit, jumpingLimit);
    }
}

class Cat extends Participant {
    public Cat(String name, int runningLimit, int jumpingLimit) {
        super(name, runningLimit, jumpingLimit);
    }
}

class Robot extends Participant {
    public Robot(String name, int runningLimit, int jumpingLimit) {
        super(name, runningLimit, jumpingLimit);
    }
}
//Классы Track и Wall, которые представляют препятствия – беговую дорожку и стену соответственно. 
//У этих классов также есть методы pass, которые вызывают методы run или jump для переданного участника.
class Track {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    public void pass(Participant participant) {
        participant.run(distance);
    }
}

class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void pass(Participant participant) {
        participant.jump(height);
    }
}
//В методе main мы создаем массивы участников и препятствий, и используем циклы for для 
//прохождения всех препятствий каждым участником. Если участник не смог пройти одно из препятствий, 
//мы прерываем прохождение для этого участника и переходим к следующему. 
//Если участник успешно проходит все препятствия, выводим соответствующее сообщение.


public class Main {
    public static void main(String[] args) {
        public Participant[] participants = {
                new Human("Иван", 1000, 2),
                new Cat("Барсик", 500, 3),
                new Robot("Робот", 2000, 1)
        };

        public Obstacle[] obstacles = {
                new Track(800),
                new Wall(2),
                new Track(1500),
                new Wall(3),
                new Track(1000)
        };

        for (Participant participant : participants) {
            boolean passedAllObstacles = true;

            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof Track) {
                    ((Track) obstacle).pass(participant);
                } else if (obstacle instanceof Wall) {
                    ((Wall) obstacle).pass(participant);
                }

                if (participant.isFailed()) {
                    passedAllObstacles = false;
                    break;
                }
            }

            if (passedAllObstacles) {
                System.out.println(participant.getName() + " успешно прошел все препятствия");
            } else {
                System.out.println(participant.getName() + " не смог пройти все препятствия");
            }
        }
    }
}