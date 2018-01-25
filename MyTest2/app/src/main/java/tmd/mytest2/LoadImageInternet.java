package tmd.mytest2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import static android.graphics.Color.WHITE;

public class LoadImageInternet extends AppCompatActivity implements View.OnClickListener {

    Button btnNext;
    Button btnPre;
    TextView txtvNameIdol;
    ImageView imgIdol;
    ProgressBar progressBar;
    ArrayList<String[]> listIdol;
    Iterator<String[]> iterator;

    int currentImage = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_internet);

        addControls();


        //chua lay duoc height cua button
        Toast.makeText(LoadImageInternet.this, "Screen Height: " + getScreenHeight() + "\nButton Height: " + btnNext.getMeasuredHeight(), Toast.LENGTH_LONG).show();
        imgIdol.setMaxHeight(getScreenHeight() - getButtonHeight(btnNext) - 20 - 10);
        //20 la khoang cach tu btnNext->Bottom, 10 la khoang cach tu imgIdol->btnNext
//        Toast.makeText(LoadImageInternet.this, "Image max Height: " + imgIdol.getMaxHeight(), Toast.LENGTH_LONG).show();

        setInfoIdol();
//        iterator = listIdol.iterator();

        btnNext.setBackgroundColor(Color.GRAY);
        btnPre.setBackgroundColor(Color.GRAY);

        //bi sai TH: currentImage = -1, khi co hinh san va an btnPre
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnNext.setOnClickListener(MainActivity.this);

                btnPre.setOnClickListener(MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPre:
                if (currentImage >= 0) {
                    currentImage--;
                }
                disableBtn(btnPre);
                if (currentImage >= 0) {
                    Toast.makeText(LoadImageInternet.this, "Loading image", Toast.LENGTH_SHORT).show();
                    new loadImageIdolFromInternet().execute((listIdol.get(currentImage))[1], "subtraction", (listIdol.get(currentImage))[0]);
                } else {
                    Toast.makeText(LoadImageInternet.this, "Hết phim", Toast.LENGTH_SHORT).show();
                    btnPre.setClickable(true);
                    btnPre.setBackgroundColor(Color.GRAY);
                }
                break;

            case R.id.btnNext:
                if (currentImage < listIdol.size()) {
                    currentImage++;
                }
                disableBtn(btnNext);
//                        //C1:// dung iterator thi khong load duoc name
//                        if (iterator.hasNext()) {
//                            Toast.makeText(LoadImageInternet.this, "Loading image", Toast.LENGTH_SHORT).show();
//                            new loadImageIdolFromInternet().execute((iterator.next())[1]);
//                            txtvNameIdol.setText(iterator.toString());
//                        }
                //C2:dung ArrayList+index
                if (currentImage < listIdol.size()) {
                    Toast.makeText(LoadImageInternet.this, "Loading image", Toast.LENGTH_SHORT).show();
                    new loadImageIdolFromInternet().execute((listIdol.get(currentImage))[1], "addition", (listIdol.get(currentImage))[0]);
                } else {
                    Toast.makeText(LoadImageInternet.this, "Hết phim", Toast.LENGTH_SHORT).show();
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(Color.GRAY);
                }
                break;
            default:

                break;
        }
    }

    private void disableBtn(Button button) {
        button.setClickable(false);
        button.setBackgroundColor(Color.WHITE);
    }

    private void addControls() {
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPre = (Button) findViewById(R.id.btnPre);
        txtvNameIdol = (TextView) findViewById(R.id.txtvNameIdol);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imgIdol = (ImageView) findViewById(R.id.imgIdol);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(LoadImageInternet.this, "onResume: \nScreen Height: " + getScreenHeight() + "\nButton Height: " + btnNext.getMeasuredHeight(), Toast.LENGTH_LONG).show();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getButtonHeight(Button btn) {
        return btn.getHeight();
    }

    public static int getButtonWidth(Button btn) {
        return btn.getWidth();
    }


    private class loadImageIdolFromInternet extends AsyncTask<String, Integer, String> {
        Bitmap bmp = null;
        int imgSize;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        private void setMaxProgressBar(int max) {
            progressBar.setMax(max);
        }


        @Override
        protected String doInBackground(String... params) {//khong duoc thay doi giao dien trong ham doInBackground
            try {

                final URL url = new URL(params[0]);
                imgSize = url.openConnection().getContentLength();

                setMaxProgressBar(imgSize);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println("bitmap");
//                        publishProgress((bmp.getRowBytes())*(bmp.getHeight()));
                    }
                }.run();

                //o day nhan duoc params[1]
                /*
                * if(params[1].equal("subtraction")){
                *   if (currentImage > 0) {
                            currentImage--;
                        }
                * }
                * */
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return params[2];//return ra String s, truyen vao ham onPostExecute
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (values[0] >= 0)
                progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            imgIdol.setImageBitmap(bmp);
            txtvNameIdol.setText(s);
            btnNext.setClickable(true);
            btnNext.setBackgroundColor(Color.GRAY);
            btnPre.setClickable(true);
            btnPre.setBackgroundColor(Color.GRAY);
            System.out.println(imgIdol.getHeight());
//            Toast.makeText(LoadImageInternet.this, imgIdol.getHeight(), Toast.LENGTH_LONG).show();

        }
    }

    private void setInfoIdol() {
        listIdol = new ArrayList<String[]>();
        listIdol.add(new String[]{"Yoshizawa Akiho", "http://topjavhd.com/wp-content/uploads/2016/09/snis222-beautiful-woman-knitting-instructor-akiho-yoshizawa-of-groping-0-bejav_com.jpg"});
        listIdol.add(new String[]{"Hoshizora Moa", "http://cfile24.uf.tistory.com/image/24316D33546771D136623F"});
        listIdol.add(new String[]{"Tsubasa Amami", "http://i.imgur.com/ydDg8nv.jpg"});
        listIdol.add(new String[]{"Erika Momotani", "http://ext.fmkorea.com/files/attach/images/1121272/829/876/063/9aede3d2d42cc42768a6348e91a39901.jpg"});
        listIdol.add(new String[]{"Suzu Mitake", "https://upic.me/i/5t/jm7g4.jpg"});
        listIdol.add(new String[]{"Emiri Suzuhara", "http://leechporn.com/Photo/Actor/NMmwV522016113855PM2.jpg"});
        listIdol.add(new String[]{"Rina Ishihara", "http://img.javcen.me/4aa49e59824ca2b7686fd91c0bb730b2.jpg"});
        listIdol.add(new String[]{"Yuino", "https://i.ytimg.com/vi/06hfJePFs-Q/maxresdefault.jpg"});
        listIdol.add(new String[]{"Iori Kogawa", "http://javhd69.net/wp-content/uploads/2016/01/star605-incest-with-sister-best-to-clean-furukawa-in-etch-iori-becomes-the-sister-of-you-love-love-incest-life-0-3xhd_net.png"});
        listIdol.add(new String[]{"Eri Hosaka", "https://s-media-cache-ak0.pinimg.com/564x/2e/d9/c1/2ed9c1d3f976eafc67feee6e98c7e408.jpg"});
        listIdol.add(new String[]{"Yui Nishikawa", "http://image.javgo.me/supd-133-digital-channel-dc-133-nishikawa-yui-life-first-gonzo.jpg"});
        listIdol.add(new String[]{"Ameri Ichinose", "https://s-media-cache-ak0.pinimg.com/564x/65/5d/fb/655dfb75ac41133cbffaf61bfe98f9fa.jpg"});
    }
}
