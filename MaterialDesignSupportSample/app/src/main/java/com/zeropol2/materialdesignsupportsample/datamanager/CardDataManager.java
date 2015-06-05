package com.zeropol2.materialdesignsupportsample.datamanager;

import com.zeropol2.materialdesignsupportsample.R;
import com.zeropol2.materialdesignsupportsample.dto.CardDto;

import java.util.ArrayList;

/**
 * Created by zeropol2 on 15. 6. 2..
 */
public class CardDataManager {

    private static CardDataManager sInstance;

    public static CardDataManager getInstance() {
        if (sInstance == null) {
            synchronized (CardDataManager.class) { // 성능을 고려하여 if 문 안쪽에 synchronized
                // 구문을 배치
                if (sInstance == null) { // 최상위 if 구문이 asynch 문 이기 때문에 한번 더 검사해야
                    // 한다.
                    sInstance = new CardDataManager();
                }
            }
        }
        return sInstance;
    }

    private CardDataManager() {

    }


    public void loadCards(AsyncDataLoader.OnDataLoadListener<ArrayList<CardDto>> l) {
        new CardsLoader(l).executeTask();
    }

    private class CardsLoader extends AsyncDataLoader<ArrayList<CardDto>> {

        public CardsLoader(OnDataLoadListener<ArrayList<CardDto>> l) {
            super(l);
        }

        @Override
        protected ArrayList<CardDto> doTask() throws CodeMessageException, InterruptedException {
            ArrayList<CardDto> result = new ArrayList<>();
            for(int i=0; i<1; i++) {
                CardDto cardDto = new CardDto();
                cardDto.photo = R.mipmap.ic_launcher;
                cardDto.name = "이름"+i;
                cardDto.age = i;
                result.add(cardDto);
            }
            return result;
        }
    }
}
