package mapper;

public interface Mapper<Input, Output> {
    Output map(Input input);
}
