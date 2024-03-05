public class Main {
    public static void main(String[] args) {
        try (// Создаем экземпляр CustomExecutorService с 4 потоками
        CustomExecutorService executorService = new CustomExecutorService(4)) {
            // Добавляем 10 задач
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                // Отправляем задачу на выполнение
                executorService.submit(() -> {
                    // Выводим информацию о выполнении задачи
                    System.out.println("Задача " + taskId + " сделана потоком " + Thread.currentThread().getName());
                });
            }
            // Завершаем работу пула потоков
            executorService.shutdown();
        }
    }
}