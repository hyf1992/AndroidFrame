package com.hyf.frame.androidframe.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by hyf on 2018/3/26.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
