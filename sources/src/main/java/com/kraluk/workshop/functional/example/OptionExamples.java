package com.kraluk.workshop.functional.example;

import com.kraluk.workshop.functional.core.exception.WorkshopException;

import javaslang.control.Option;

/**
 * Option Examples
 *
 * @author lukasz
 */
public class OptionExamples {

    public static Integer someSimpleOption() {
        Option<Integer> option = Option.of(null);

        return option.getOrElseThrow(() -> new WorkshopException("Can't."));
    }
}