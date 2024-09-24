SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;


CREATE TABLE public.cidade
(
    id        bigint                 NOT NULL,
    nome      character varying(255) NOT NULL,
    tamanho   character varying(255),
    estado_id bigint                 NOT NULL
);

ALTER TABLE public.cidade
    OWNER TO "mateus.hemkemeier";

ALTER TABLE public.cidade
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.cidade_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

CREATE TABLE public.estado
(
    id        bigint                 NOT NULL,
    descricao character varying(255),
    nome      character varying(255) NOT NULL,
    pais_id   bigint                 NOT NULL
);

ALTER TABLE public.estado
    OWNER TO "mateus.hemkemeier";

ALTER TABLE public.estado
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.estado_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

CREATE TABLE public.pais
(
    id   bigint                 NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE public.pais
    OWNER TO "mateus.hemkemeier";

ALTER TABLE public.pais
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.pais_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

COPY public.pais (id, nome) FROM stdin;
1	Afeganistão
2	Albânia, Republica da
3	Argélia
4	Samoa Americana
5	Andorra
6	Angola
7	Antártida
8	Antigua e Barbuda
9	Armênia, Republica da
10	Aruba
11	Áustria
12	Azerbaijão, Republica do
13	Bahamas, Ilhas
14	Bahrein, Ilhas
15	Bangladesh
16	Barbados
17	Belarus, Republica da
18	Bélgica
19	Belize
20	Benin
21	Bermudas
22	Butão
23	Bolívia
24	Bósnia-herzegovina (Republica da)
25	Botsuana
26	Bouvet, Ilha
27	Território Britânico do Oceano Indico
28	Brunei
29	Bulgária, Republica da
30	Burkina Faso
31	Burundi
32	Camboja
33	Camarões
34	Cabo Verde, Republica de
35	Republica Centro-Africana
36	Chade
37	Chile
38	China, Republica Popular
39	Christmas, Ilha (Navidad)
40	Cocos (Keeling), Ilhas
41	Colômbia
42	Comores, Ilhas
43	Congo
44	Congo, Republica Democrática do
45	Cook, Ilhas
46	Costa Rica
47	Costa do Marfim
48	Croácia (Republica da)
49	Cuba
50	Chipre
51	Tcheca, Republica
52	Dinamarca
53	Djibuti
54	Dominica, Ilha
55	Republica Dominicana
56	Timor Leste
57	Equador
58	Egito
59	El Salvador
60	Guine-Equatorial
61	Eritreia
62	Estônia, Republica da
63	Etiópia
64	Falkland (Ilhas Malvinas)
65	Feroe, Ilhas
66	Fiji
67	Finlândia
68	Franca
69	Guiana francesa
70	Polinésia Francesa
71	Terras Austrais e Antárticas Francesas
72	Gabão
73	Gambia
74	Georgia, Republica da
75	Alemanha
76	Gana
77	Gibraltar
78	Grécia
79	Groenlândia
80	Granada
81	Guadalupe
82	Guam
83	Guatemala
84	Guine
85	Guine-Bissau
86	Guiana
87	Haiti
88	Ilha Heard e Ilhas McDonald
89	Vaticano, Estado da Cidade do
90	Honduras
91	Hong Kong
92	Hungria, Republica da
93	Islândia
94	Indonésia
95	Ira, Republica Islâmica do
96	Iraque
97	Irlanda
98	Israel
99	Jamaica
100	Jordânia
101	Cazaquistão, Republica do
102	Quênia
103	Kiribati
104	Coreia, Republica Popular Democrática da
105	Coreia, Republica da
106	Canadá
107	Ilhas Caimã
108	Itália
109	Brasil
110	Austrália
111	Japão
112	Índia
113	Kuwait
114	Quirguiz, Republica
115	Laos, Republica Popular Democrática do
116	Letônia, Republica da
117	Líbano
118	Lesoto
119	Libéria
120	Líbia
121	Liechtenstein
122	Lituânia, Republica da
123	Luxemburgo
124	Macau
125	Macedônia do Norte
126	Madagascar
127	Malavi
128	Malásia
129	Maldivas
130	Mali
131	Malta
132	Marshall, Ilhas
133	Martinica
134	Mauritânia
135	Mauricio
136	Mayotte (Ilhas Francesas)
137	México
138	Micronesia
139	Moldávia, Republica da
140	Mongólia
141	Montserrat, Ilhas
142	Marrocos
143	Moçambique
144	Mianmar (Birmânia)
145	Namíbia
146	Nauru
147	Nepal
148	Países Baixos (Holanda)
149	Nova Caledonia
150	Nova Zelândia
151	Nicarágua
152	Níger
153	Nigéria
154	Niue, Ilha
155	Norfolk, Ilha
156	Marianas do Norte
157	Noruega
158	Oma
159	Paquistão
160	Palau
161	Panamá
162	Papua Nova Guine
163	Paraguai
164	Peru
165	Filipinas
166	Pitcairn, Ilha
167	Polônia, Republica da
168	Portugal
169	Porto Rico
170	Catar
171	Reunião, Ilha
172	Romênia
173	Ruanda
174	São Cristovão e Neves, Ilhas
175	Santa Lucia
176	São Vicente e Granadinas
177	Samoa
178	San Marino
179	São Tome e Príncipe, Ilhas
180	Arábia Saudita
181	Senegal
182	Seychelles
183	Serra Leoa
184	Cingapura
185	Eslovaca, Republica
186	Eslovênia, Republica da
187	Salomão, Ilhas
188	Somalia
189	Ilhas Geórgia do Sul e Sandwich do Sul
190	Espanha
191	Sri Lanka
192	Santa Helena
193	São Pedro e Miquelon
194	Sudão
195	Suriname
196	Svalbard e Jan Mayen
197	Eswatini
198	Suécia
199	Suíça
200	Síria, Republica Árabe da
201	Formosa (Taiwan)
202	Tadjiquistao, Republica do
203	Tanzânia, Republica Unida da
204	Tailândia
205	Togo
206	Toquelau, Ilhas
207	Tonga
208	Trinidad e Tobago
209	Tunísia
210	Turquia
211	Turcomenistão, Republica do
212	Turcas e Caicos, Ilhas
213	Tuvalu
214	Uganda
215	Ucrânia
216	Emirados Árabes Unidos
217	Reino Unido
218	Estados Unidos
219	Ilhas Menores Distantes dos Estados Unidos
220	Uruguai
221	África do Sul
222	Mônaco
223	Uzbequistão, Republica do
224	Vanuatu
225	Venezuela
226	Vietnã
227	Virgens, Ilhas (Britânicas)
228	Virgens, Ilhas (E.U.A.)
229	Wallis e Futuna, Ilhas
230	Saara Ocidental
231	Iémen
232	Iugoslávia, República Fed. da
233	Zâmbia
234	Zimbabue
235	Guernsey, Ilha do Canal (Inclui Alderney e Sark)
236	Jersey, Ilha do Canal
237	Man, Ilha de
238	Montenegro
239	Republika Srbija
240	Sudao do Sul
241	Zona do Canal do Panamá
242	Palestina
243	Aland, Ilhas
244	Coletividade de São Bartolomeu
245	Curaçao
246	São Martinho, Ilha de (Parte Francesa)
247	Bonaire
248	Antartica
249	Ilha Herad e Ilhas Macdonald
250	São Bartolomeu
251	São Martinho, Ilha de (Parte Holandesa)
252	Terras Austrais e Antárcticas Francesas
253	Anguila
254	Argentina
255	Rússia, Federação da
\.


SELECT pg_catalog.setval('public.cidade_id_seq', 1, false);

SELECT pg_catalog.setval('public.estado_id_seq', 1, true);

SELECT pg_catalog.setval('public.pais_id_seq', 256, true);

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT uk_5a31x29qme0ctihxk0lsx1819 UNIQUE (nome);

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT uk_gfot2y0318rs8hc74ppp0n87p UNIQUE (nome);

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT uk_lwg97fq9vkwb5vlqo59krrxoa UNIQUE (nome);

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT fkkworrwk40xj58kevvh3evi500 FOREIGN KEY (estado_id) REFERENCES public.estado (id);

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT fklsmaqvrvjo414pa0u6kiusg5 FOREIGN KEY (pais_id) REFERENCES public.pais (id);
