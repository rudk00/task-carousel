package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean isCompleted = false;
    private boolean isExecuted = false;

    @Override
    public void execute() {
        if (isCompleted) isExecuted = true;
    }

    @Override
    public boolean isFinished() {
        return isExecuted;
    }

    public void complete() {
        isCompleted = true;
    }
}
