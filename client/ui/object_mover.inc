	<Page
		Name='ObjectMover'
		ScrollExtent='500,500'
		Size='500,500'
		Visible='false'
	>
		<Page
			Location='11,40'
			MinimumSize='484,240'
			Name='mover'
			RStyleDefault='rs_default'
			ScrollExtent='484,380'
			Size='484,380'
			UserMovable='true'
		>
			<Page
				Location='9,280'
				Name='z'
				ScrollExtent='470,40'
				Size='470,40'
				value.Text='0'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='Z'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>Z</Button>
			</Page>
			<Page
				Location='9,240'
				Name='y'
				ScrollExtent='470,40'
				Size='470,40'
				value.Text='0'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='Y'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>Y</Button>
			</Page>
			<Page
				Location='9,200'
				Name='x'
				ScrollExtent='470,40'
				Size='470,40'
				value.Text='0'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='X'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>X</Button>
			</Page>
			<Page
				Location='9,140'
				Name='pitch'
				ScrollExtent='470,40'
				Size='470,40'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
					value.text.Text='43'
					Valueparent.maxcorelevel.text.Text='43'
					Valueparent.yaw.value.Text='34'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='Pitch'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>Pitch</Button>
			</Page>
			<Page
				Location='9,100'
				Name='roll'
				ScrollExtent='470,40'
				Size='470,40'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='Roll'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>Roll</Button>
			</Page>
			<Page
				Location='9,60'
				Name='yaw'
				ScrollExtent='470,40'
				Size='470,40'
				value.Text='0'
			>
				<Sliderbar
					AutoRegister='true'
					Location='170,10'
					LowerLimit='-90'
					Name='slider'
					OnDisable='opacity=0.3'
					OnEnable='opacity=1.0'
					OnSliderChange='parent.value.Text = Value'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='260,20'
					Size='260,20'
					Style='/Styles.New.Slider.default.horizontal.style_test'
					UpperLimit='90'
					UpperLimitAllowed='90'
				>
				</Sliderbar>
				<Text
					Font='/Fonts.verdana_bold_12'
					LocalText='0'
					Location='430,10'
					MinimumSize='0,19'
					Name='value'
					OpacityRelativeMin='0.80'
					PackLocation='nfn,nfn'
					PackSize='h,f'
					PalText='header'
					ScrollExtent='40,21'
					Size='40,21'
					text.Text='28'
					TextAlignment='Center'
					TextAlignmentVertical='Center'
					TextColor='#97FFFF'
				>0</Text>
				<Button
					LocalText='Yaw'
					Location='10,10'
					Name='buttonMove'
					OpacityRelativeMin='0.70'
					PackLocation='fff,fff'
					PackSize='p,f'
					RStyleDefault='/Styles.New.buttons.hud.style'
					ScrollExtent='152,18'
					Size='152,18'
					Style='/Styles.New.buttons.hud.style'
				>Yaw</Button>
			</Page>
			<Text
				Font='/Fonts.verdana_bold_12'
				LocalText='999999'
				Location='184,30'
				MinimumSize='0,19'
				Name='currentTarget'
				OpacityRelativeMin='0.80'
				PackLocation='nfn,nfn'
				PackSize='h,f'
				PalText='header'
				ScrollExtent='290,21'
				Size='290,21'
				TextAlignment='Center'
				TextAlignmentVertical='Center'
				TextColor='#97FFFF'
			>999999</Text>
			<Button
				LocalText='Set Object'
				Location='19,40'
				Name='buttonSend'
				OpacityRelativeMin='0.70'
				PackLocation='fff,fff'
				PackSize='p,f'
				RStyleDefault='/Styles.New.buttons.hud.style'
				ScrollExtent='152,18'
				Size='152,18'
				Style='/Styles.New.buttons.hud.style'
			>Set Object</Button>
			<Button
				LocalText='Move To Me'
				Location='16,344'
				Name='buttonMoveToMe'
				OpacityRelativeMin='0.70'
				PackLocation='fff,fff'
				PackSize='p,f'
				RStyleDefault='/Styles.New.buttons.hud.style'
				ScrollExtent='152,18'
				Size='152,18'
				Style='/Styles.New.buttons.hud.style'
			>Move To Me</Button>
			<Button
				LocalText='Object Viewer'
				Location='176,344'
				Name='buttonObjectViewer'
				OpacityRelativeMin='0.70'
				PackLocation='fff,fff'
				PackSize='p,f'
				RStyleDefault='/Styles.New.buttons.hud.style'
				ScrollExtent='112,18'
				Size='112,18'
				Style='/Styles.New.buttons.hud.style'
			>Object Viewer</Button>
			<Button
				IsDefaultButton='true'
				LocalText='Close'
				Location='302,344'
				Name='buttonCancel'
				OpacityRelativeMin='0.70'
				PackLocation='fff,fff'
				PackSize='p,f'
				RStyleDefault='/Styles.New.buttons.hud.style'
				ScrollExtent='152,18'
				Size='152,18'
				Style='/Styles.New.buttons.hud.style'
			>Close</Button>
			<Page
				Name='bg'
				PackLocation='nfn,nfn'
				PackSize='a,a'
				ScrollExtent='484,380'
				Size='484,380'
			>
				<Page
					Location='474,8'
					Name='mmc'
					PackLocation='fff,nfn'
					PackSize='f,f'
					RStyleDefault='/Styles.New.thin_mmc.rs_default'
					ScrollExtent='12,10'
					Size='12,10'
				>
					<Button
						BackgroundColor='#FFFFFF'
						BackgroundOpacity='0.80'
						IsCancelButton='true'
						Location='-4,-3'
						Name='close'
						OpacityRelativeMin='0.80'
						PackLocation='fff,cfc'
						PackSize='f,f'
						ScrollExtent='16,16'
						Size='16,16'
						Style='/Styles.Frame.buttonClose.style'
					></Button>
				</Page>
				<Page
					Name='caption'
					PackLocation='nfn,nfn'
					PackSize='a,f'
					ScrollExtent='337,18'
					Size='337,18'
				>
					<Text
						Enabled='false'
						Font='/Fonts.verdana_bold_12'
						LocalText='OBJECT MOVER'
						Margin='6,-2,0,0'
						MaxLines='1'
						Name='text'
						OpacityRelativeMin='0.80'
						PackSize='a,f'
						PalText='titletext'
						ScrollExtent='470,18'
						Size='470,18'
						TextAlignmentVertical='Center'
						TextCapital='true'
						TextColor='#00354F'
					>Object Mover</Text>
				</Page>
				<Page
					BackgroundTint='#00D6FB'
					GetsInput='false'
					Location='1,0'
					Name='frame'
					PackLocation='nfn,nfn'
					PackSize='a,a'
					PalBgTint='baselight'
					RStyleDefault='/Styles.New.thin_in.rs_default'
					ScrollExtent='483,380'
					Selectable='true'
					Size='483,380'
				>
					<Page
						BackgroundColor='#FFFFFF'
						GetsInput='false'
						Location='1,0'
						Name='lines'
						PackSize='a,a'
						RStyleDefault='/Styles.space.boxes.generic4.rs_default'
						ScrollExtent='483,380'
						Size='483,380'
					>
						<Page
							BackgroundColor='#FFFFFF'
							GetsInput='false'
							Location='0,358'
							Name='outlineBL'
							OpacityRelativeMin='0.80'
							PackLocation='nfn,fff'
							PackSize='p,f'
							ScrollExtent='381,22'
							Size='381,22'
						>
							<Page
								BackgroundColor='#FFFFFF'
								BackgroundOpacity='1.00'
								BackgroundTint='#1CFFFF'
								GetsInput='false'
								Location='0,13'
								Name='outline1'
								OpacityRelativeMin='0.80'
								PackSize='a,a'
								PalBgTint='line1'
								RStyleDefault='/Styles.space.boxes.boxlinebottomLeft2.rs_default'
								ScrollExtent='283,9'
								Size='283,9'
							/>
						</Page>
						<Page
							BackgroundColor='#FFFFFF'
							GetsInput='false'
							Location='131,358'
							Name='outlineBR'
							OpacityRelativeMin='0.80'
							PackLocation='fff,fff'
							PackSize='p,f'
							RStyleDefault='/Styles.space.boxes.boxlineTopLeft.rs_default'
							ScrollExtent='352,22'
							Size='352,22'
						>
							<Page
								BackgroundColor='#FFFFFF'
								BackgroundOpacity='1.00'
								BackgroundTint='#1CFFFF'
								GetsInput='false'
								Location='0,13'
								Name='outline1'
								OpacityRelativeMin='0.80'
								PackSize='a,a'
								PalBgTint='line1'
								RStyleDefault='/Styles.space.boxes.boxlinebottomRight2.rs_default'
								ScrollExtent='261,9'
								Size='261,9'
							/>
						</Page>
						<Page
							BackgroundColor='#FFFFFF'
							GetsInput='false'
							Location='131,0'
							Name='outlineTR'
							OpacityRelativeMin='0.80'
							PackLocation='fff,nfn'
							PackSize='p,f'
							ScrollExtent='352,22'
							Size='352,22'
						>
							<Page
								BackgroundColor='#FFFFFF'
								BackgroundOpacity='1.00'
								BackgroundTint='#1CFFFF'
								GetsInput='false'
								Name='outline1'
								OpacityRelativeMin='0.80'
								PackSize='a,a'
								PalBgTint='line1'
								RStyleDefault='/Styles.space.boxes.boxlineTopRight2.rs_default'
								ScrollExtent='450,9'
								Size='450,9'
							/>
						</Page>
						<Page
							BackgroundColor='#FFFFFF'
							GetsInput='false'
							Name='outlineTL'
							OpacityRelativeMin='0.80'
							PackLocation='nfn,nfn'
							PackSize='p,f'
							RStyleDefault='/Styles.space.boxes.boxlineTopLeft.rs_default'
							ScrollExtent='381,22'
							Size='381,22'
						>
							<Page
								BackgroundColor='#FFFFFF'
								BackgroundOpacity='1.00'
								BackgroundTint='#1CFFFF'
								GetsInput='false'
								Name='outline1'
								OpacityRelativeMin='0.80'
								PackSize='a,a'
								PalBgTint='line1'
								RStyleDefault='/Styles.space.boxes.boxlineTopLeft2.rs_default'
								ScrollExtent='487,9'
								Size='487,9'
							/>
						</Page>
					</Page>
					<Page
						BackgroundOpacity='1.00'
						Location='-1,0'
						Name='top'
						PackLocation='nfn,nfn'
						PackSize='a,f'
						RStyleDefault='/Styles.New.main_TR.rs_default'
						ScrollExtent='484,29'
						Size='484,29'
					/>
					<Page
						BackgroundOpacity='1.00'
						Location='0,357'
						Name='bottom'
						PackLocation='nfn,fff'
						PackSize='a,f'
						RStyleDefault='/Styles.New.main_BR.rs_default'
						ScrollExtent='483,23'
						Size='483,23'
					/>
				</Page>
				<Page
					BackgroundOpacity='1.00'
					BackgroundTint='#00D6FB'
					GetsInput='false'
					Location='0,5'
					Name='back'
					PackLocation='nfn,nfn'
					PackSize='a,a'
					PalBgTint='back1'
					RStyleDefault='/Styles.New.thin_in.rs_default'
					ScrollExtent='484,372'
					Selectable='true'
					Size='484,372'
				/>
				<Page
					BackgroundOpacity='1.00'
					BackgroundTint='#00D6FB'
					GetsInput='false'
					Name='back'
					PackLocation='nfn,nfn'
					PackSize='a,a'
					PalBgTint='back1'
					RStyleDefault='/Styles.space.spaceglow.rs_default'
					ScrollExtent='484,380'
					Selectable='true'
					Size='484,380'
				/>
			</Page>
		</Page>
	</Page>
