package com.carrot.learn.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.descriptor.MojoDescriptor;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 自定义maven插件：可以用来自定义打包方式
 */
@Mojo(name = "kyg")
public class KygPlugin extends AbstractMojo {

    @Parameter
    String sex;
    @Parameter
    String describe;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(String.format("kyg sex:%s describe:%s",sex,describe));
    }
}
