package Class_exercises.Segon_parcial_19_20;

import Class_exercises.Segon_parcial_19_20.Exceptions.ConditionsNotAchieved;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Design-pattern-examples.
 * @author: mcr99 on 31/05/2022.
 */
public class EmailBuilder {
    private String from;
    private List<String> tos = new ArrayList<>();
    private String subject;
    private String body;
    private List<String> ccTo = new ArrayList<>();

    public EmailBuilder from(String from) {
        this.from = from;
        return this;
    }

    public EmailBuilder to(String tos) {
        this.tos.add(tos);
        return this;
    }

    public EmailBuilder subject(String subject) {

        this.subject = subject;
        return this;
    }

    public EmailBuilder body(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder cctos(String ccTo) {
        this.ccTo.add(ccTo);
        return this;
    }

    public Email make() throws ConditionsNotAchieved {
        checkConditions();
        if (this.ccTo.isEmpty()) {
            return new Email(this.from, this.tos, this.subject, this.body);
        } else {
            return new Email(this.from, this.tos, this.subject, this.body, this.ccTo);
        }
    }

    private void checkConditions() throws ConditionsNotAchieved {
        if (from == null){
            throw new ConditionsNotAchieved("No from");
        } else if (subject == null) {
            throw new ConditionsNotAchieved("No subject");
        } else if (body == null) {
            throw new ConditionsNotAchieved("No body");
        } else if (tos == null) {
            throw new ConditionsNotAchieved("No to");
        }
    }
}
