import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CountWordsTask extends RecursiveTask<Long> {

    private final Path path;
    private final String word;

    public CountWordsTask(Path path, String word){
        this.path = path;
        this.word = word;
    }

    @Override
    protected Long compute(){
        if(!Files.isDirectory(path)){
            return WordCounter.countWordInFile(path, word);
        }

        Stream<Path> subPaths;
        try{
            subPaths = Files.list(path);
        }catch (IOException ioEx){
            return 0L;
        }

        List<CountWordsTask> subTasks =
                subPaths.map(path -> new CountWordsTask(path, word))
                        .collect(Collectors.toList());
                        invokeAll(subTasks);

                        return subTasks.stream()
                                .mapToLong(CountWordsTask::getRawResult)
                                .sum();
    }

}
