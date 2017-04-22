package com.lobotomist.geo.comparsion.Api.Google;

import com.google.gson.annotations.SerializedName;

/**
 * Google response class
 */
class Response {
    @SerializedName("routes")
    protected Route[] routes;

    protected class Route {
        @SerializedName("legs")
        protected Leg[] legs;

        public Leg getShortestLeg() {
            Leg shortest = null;

            for (Leg leg : this.legs) {
                if (shortest == null || shortest.distance.value > leg.distance.value) {
                    shortest = leg;
                }
            }

            return shortest;
        }


        protected class Leg {
            @SerializedName("distance")
            protected Meta distance;

            protected class Meta {
                @SerializedName("value")
                protected float value;
            }
        }
    }
}