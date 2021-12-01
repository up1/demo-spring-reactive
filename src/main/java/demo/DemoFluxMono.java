package demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Observable;

import static java.lang.Thread.sleep;

public class DemoFluxMono {
    public static void main(String[] args) throws InterruptedException {
//        useFlux();
//        useFlux2();
//        useFlux3();
//        useMono();
    }

    private static void useFlux() {
        Flux.empty()
                .subscribe(i -> System.out.println("Received empty : " + i));

        Flux.just(1)
                .subscribe(i -> System.out.println("Received 1 : " + i));

        Flux<Integer> flux = Flux.just(1);
        //Observer 1
        flux.subscribe(i -> System.out.println("Observer-1 : " + i));
        //Observer 2
        flux.subscribe(i -> System.out.println("Observer-2 : " + i));

        Flux.just('a', 'b', 'c')
                .subscribe(i -> System.out.println("Received many : " + i));

    }

    private static void useFlux2() throws InterruptedException {
        //flux emits one element per second
        Flux<Character> flux = Flux.just('a', 'b', 'c', 'd')
                .delayElements(Duration.ofSeconds(1));
        //Observer 1 - takes 500ms to process
        flux
                .map(Character::toUpperCase)
                .subscribe(i -> {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Observer-1 : " + i);
                });

        //Observer 2 - process immediately
        flux.subscribe(i -> System.out.println("Observer-2 : " + i));

        // Waiting for results
        Thread.sleep(10000);
    }

    private static void useFlux3() throws InterruptedException {
        Flux.just(4, 3, 2, 1)
                .map(i -> i / (i-1))
                .subscribe(
                        i -> System.out.println("Received :: " + i),
                        err -> System.out.println("Error :: " + err),
                        () -> System.out.println("Successfully completed"));
    }

    private static void useMono() {
        Mono.just("Hello")
                .subscribe(
                        i -> System.out.println("Received :: " + i),
                        err -> System.out.println("Error :: " + err),
                        () -> System.out.println("Successfully completed"));
    }

}

