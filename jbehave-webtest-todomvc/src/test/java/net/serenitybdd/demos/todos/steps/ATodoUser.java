package net.serenitybdd.demos.todos.steps;

import net.serenitybdd.demos.todos.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.pages.TodoPage;
import net.thucydides.core.annotations.Step;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ATodoUser {


    @Step
    public void opens_the_todo_application() {
        onTheTodoHomePage.open();
    }

    TodoPage onTheTodoHomePage;

    @Step
    public void adds_an_action_called(String actionName) {
        onTheTodoHomePage.addAnActionCalled(actionName);
    }

    @Step
    public void has_added_actions_called(String... actionNames) {
        newArrayList(actionNames).forEach(
                action -> adds_an_action_called(action)
        );
    }

    @Step
    public void should_see_the_todo_action(String action) {
        assertThat(onTheTodoHomePage.getActions()).contains(action);
    }

    @Step
    public void should_see_the_todo_actions(String... actionNames) {
        assertThat(onTheTodoHomePage.getActions()).containsExactly(actionNames);
    }

    @Step
    public void filters_by_status(TodoStatusFilter status) {
        onTheTodoHomePage.filterByStatus(status);
    }


    @Step("Completes the action called '{0}'")
    public void completes_the_action_called(String actionName) {
        onTheTodoHomePage.markComplete(actionName);
    }

    @Step
    public void clears_the_completed_actions() {
        onTheTodoHomePage.clearCompletedActions();
    }
}
