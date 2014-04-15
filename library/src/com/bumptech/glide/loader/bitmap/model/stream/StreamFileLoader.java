package com.bumptech.glide.loader.bitmap.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.loader.bitmap.model.FileLoader;
import com.bumptech.glide.loader.bitmap.model.GenericLoaderFactory;
import com.bumptech.glide.loader.bitmap.model.ModelLoader;
import com.bumptech.glide.loader.bitmap.model.ModelLoaderFactory;

import java.io.File;
import java.io.InputStream;

/**
 * A {@link ModelLoader} For translating {@link File} models for local uris into {@link InputStream} resources.
 */
public class StreamFileLoader extends FileLoader<InputStream> implements StreamModelLoader<File> {

    public static class Factory implements ModelLoaderFactory<File, InputStream> {
        @Override
        public ModelLoader<File, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new StreamFileLoader(factories.buildModelLoader(Uri.class, InputStream.class, context));
        }

        @Override
        public Class<? extends ModelLoader<File, InputStream>> loaderClass() {
            return StreamFileLoader.class;
        }

        @Override
        public void teardown() { }
    }

    public StreamFileLoader(Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamFileLoader(ModelLoader<Uri, InputStream> uriLoader) {
        super(uriLoader);
    }

}